package com.example.resurreccion_exer4_slambook

import android.provider.ContactsContract

data class Entry(
    var name: String="",
    var nickname: String="",
    var age: Int,
    var birthday: String="",
    var course: String="",
    var phone: ContactsContract.CommonDataKinds.Phone,
    var color: String="",
    var dream: String="",
    var crush: String="",
    var message: String=""
)