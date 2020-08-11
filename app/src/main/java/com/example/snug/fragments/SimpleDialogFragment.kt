package com.example.snug.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.lang.ClassCastException

class SimpleDialogFragment: DialogFragment() {

    private lateinit var listener: SimpleDialogListener

        interface SimpleDialogListener{
            fun onDialogPositiveClick(dialog: DialogFragment)
            fun onDialogNegativeClick(dialog: DialogFragment)
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as SimpleDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // ダイアログの生成
            val builder = AlertDialog.Builder(it)
            builder.setMessage("OKかキャンセルを選択してください")
                .setPositiveButton("OK") { dialog, id ->
                    // 呼び出し元のActivityで定義されているonDialogPositiveClickが実行される
                    listener.onDialogPositiveClick(this)
                }
                .setNegativeButton("キャンセル") { dialog, id ->
                    // 呼び出し元のActivityで定義されているonDialogNegativeClickが実行される
                    listener.onDialogNegativeClick(this)
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

