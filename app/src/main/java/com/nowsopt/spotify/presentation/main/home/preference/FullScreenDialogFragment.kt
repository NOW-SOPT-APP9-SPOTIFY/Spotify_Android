package com.nowsopt.spotify.presentation.main.home.preference

import android.animation.ObjectAnimator
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.RenderEffect
import android.graphics.Shader
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.core.animation.doOnEnd
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.nowsopt.spotify.R

class FullScreenDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.dialog_layout, container, false)
            .apply {
                val window = dialog?.window
                window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                window?.setGravity(Gravity.CENTER or Gravity.BOTTOM)
                window?.attributes?.windowAnimations = R.style.DialogAnimation
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomDialogTheme)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.btn_dialog_close).setOnClickListener {
            dismiss()
        }

        view.findViewById<TextView>(R.id.tv_dialog_artist).setOnClickListener {
            dismiss()
            findNavController().navigate(R.id.action_home_navigation_to_artist_fragment)
        }
    }

    override fun onResume() {
        super.onResume()
        val device = context?.applicationContext?.resources?.displayMetrics
        val x = device?.widthPixels
        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        params?.width = x
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    override fun onStart() {
        super.onStart()

        activity?.window?.decorView?.rootView?.let { rootView ->
            val blurEffect = RenderEffect.createBlurEffect(90f, 90f, Shader.TileMode.REPEAT)
            rootView.setRenderEffect(blurEffect)
        }
    }


    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)

        activity?.window?.decorView?.rootView?.let { rootView ->
            val blurAnimator = ObjectAnimator.ofFloat(90f, 0.01f).apply {
                duration = 500
                addUpdateListener { animation ->
                    val animatedValue = animation.animatedValue as Float
                    val blurEffect = RenderEffect.createBlurEffect(
                        animatedValue,
                        animatedValue,
                        Shader.TileMode.REPEAT
                    )
                    rootView.setRenderEffect(blurEffect)
                }
                doOnEnd {
                    rootView.setRenderEffect(null)
                }
            }
            blurAnimator.start()
        }
    }

    companion object {
        fun newInstance(): FullScreenDialogFragment {
            return FullScreenDialogFragment()
        }
    }
}