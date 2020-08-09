package com.example.snug.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.snug.R
import com.example.snug.realm.User
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        realm = Realm.getDefaultInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onStart() {
        super.onStart()

        // 最初に読み込みを行う
        this.load()
    }

    fun save() {
        // IDは0で固定
        val user = User()
        user.name = nameField.text.toString()
        user.phone = phoneField.text.toString()
        user.mail = mailField.text.toString()
        // 保存（idが主キーなので、保存or更新）
        realm.executeTransactionAsync({ realm ->
            realm.copyToRealmOrUpdate(user)
        }, {
            Toast.makeText(this.context, "保存しました。", Toast.LENGTH_SHORT).show()
        }, { error ->
            Toast.makeText(this.context, "保存に失敗しました。", Toast.LENGTH_SHORT).show()
        })
    }

    fun load() {
        // ユーザ取得
        val user = realm.where<User>().findFirst()
        user?.let {
            // ユーザが存在する場合に実行
            nameField.setText(it.name, TextView.BufferType.NORMAL)
            phoneField.setText(it.phone, TextView.BufferType.NORMAL)
            mailField.setText(it.mail, TextView.BufferType.NORMAL)
        }
    }
}