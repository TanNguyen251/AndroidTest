package com.example.androidtest

import java.io.Serializable

data class User (
    var name: String,
    var email: String,
    var phone: String,
    var street: String,
    var city: String,
    var country: String
    ) : Serializable