package com.example.snug.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User: RealmObject() {
    @PrimaryKey
    var id: Int = 0
    var name: String = ""
    var phone: String = ""
    var mail: String = ""
}