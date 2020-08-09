package com.example.snug.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.snug.R
import com.example.snug.realm.Animals
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_second, container,false)
    }

    override fun onStart() {
        super.onStart()
        // 最初に読み込みを行う
        this.load()
    }

    fun save() {

        val animal = Animals()
        animal.animal1 = animal1.text.toString()
        animal.animal2 = animal2.text.toString()
        animal.animal3 = animal3.text.toString()

        realm.executeTransactionAsync({ realm ->
            realm.copyToRealmOrUpdate(animal)
        }, {
            Toast.makeText(this.context, "保存しました。", Toast.LENGTH_SHORT).show()
        }, { error ->
            Toast.makeText(this.context, "保存に失敗しました。", Toast.LENGTH_SHORT).show()
        })
    }

    fun load() {
        val animal = realm.where<Animals>().findFirst()
        animal?.let {
            animal1.setText(it.animal1, TextView.BufferType.NORMAL)
            animal2.setText(it.animal2, TextView.BufferType.NORMAL)
            animal3.setText(it.animal3, TextView.BufferType.NORMAL)
        }
    }
}