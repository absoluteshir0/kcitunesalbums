package sn.nino.kcitunesalbums.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import sn.nino.kcitunesalbums.databinding.DialogProgressBinding

class UIDialogs {
    companion object {
        fun progressDialog(context: Context): Dialog {
            val layout: DialogProgressBinding = DialogProgressBinding.inflate(LayoutInflater.from(context))
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(layout.getRoot())
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val window = dialog.window
            val wlp = window!!.attributes
            wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
            window.attributes = wlp

            return dialog
        }
    }

}