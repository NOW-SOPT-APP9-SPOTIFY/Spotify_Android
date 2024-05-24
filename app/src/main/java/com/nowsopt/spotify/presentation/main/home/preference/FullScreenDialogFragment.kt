package com.nowsopt.spotify.presentation.main.home.preference

import android.animation.ObjectAnimator
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.RenderEffect
import android.graphics.Shader
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.animation.doOnEnd
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.DialogLayoutBinding

class FullScreenDialogFragment(
    val albumId: Int,
    val artistName: String,
    val albumName: String,
) : DialogFragment() {

    private var _binding: DialogLayoutBinding? = null
    private val binding
        get() = requireNotNull(_binding) { "ERRORRRRR" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogLayoutBinding.inflate(inflater, container, false)
        return binding.root.apply {
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

        binding.btnDialogClose.setOnClickListener {
            dismiss()
        }

        binding.tvDialogArtist.setOnClickListener {
            dismiss()
            findNavController().navigate(R.id.action_home_navigation_to_artist_fragment)
        }

        val image = when (albumId) {
            1 -> R.drawable.img_bruno
            6 -> R.drawable.img_the_script
            else -> R.drawable.img_xxanteria
        }

        binding.ivDialogMusicAlbumMini.setImageResource(image)
        binding.tvDialogMusicTitleMini.text = albumName
        binding.tvDialogMusicAlbumMini.text = "앨범 · $artistName"
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(
            albumId: Int,
            artistName: String,
            albumName: String,
        ): FullScreenDialogFragment {
            return FullScreenDialogFragment(
                albumId = albumId,
                artistName = artistName,
                albumName = albumName
            )
        }
    }
}
