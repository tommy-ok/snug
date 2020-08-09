package com.example.snug.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class SimpleDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("保存しますか？")
            .setMessage("次回から読込ボタンで入力情報を読み込めます")
            .setPositiveButton("保存") { dialog, id ->
                println("dialog:$dialog which:$id")
            }
            .setNegativeButton("キャンセル") { dialog, id ->
                println("dialog:$dialog which:$id")
            }
        return builder.create()
    }
}