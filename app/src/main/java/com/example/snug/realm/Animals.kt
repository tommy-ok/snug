package com.example.snug.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Animals: RealmObject() {
    @PrimaryKey
    var id: Int = 0
    var animal1: String = ""
    var animal2: String = ""
    var animal3: String = ""
}