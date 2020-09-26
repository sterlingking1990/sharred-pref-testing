package com.example.classwork

open class User (
        var firstName: String?,
        var lastName: String?,
        var otherName:String?,
        var category:String?="",
        var phone:String?,
        var password:String?
) {
    var loggedIn: Boolean = false
    var message = ""
}
