package com.gmail.gromovitaly.telegram_clone.models

data class User(
    val id: String = "",
    var uresname: String = "",
    var phone: String = "",
    var bio: String = "",
    var fullanmee: String = "",
    var status: String = "",
    var photoUrl: String = ""
)