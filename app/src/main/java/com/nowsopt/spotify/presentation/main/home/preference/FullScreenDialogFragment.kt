package com.nowsopt.spotify.presentation.main.home.preference

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class FullScreenDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(com.nowsopt.spotify.R.layout.dialog_layout, container, false)
            .apply {
                val window = dialog?.window
                window?.setGravity(Gravity.CENTER or Gravity.BOTTOM)
                window?.attributes?.windowAnimations = com.nowsopt.spotify.R.style.DialogAnimation
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setWindowAnimations(com.nowsopt.spotify.R.style.DialogAnimation)
    }

    companion object {
        fun newInstance(): FullScreenDialogFragment {
            return FullScreenDialogFragment()
        }
    }
}