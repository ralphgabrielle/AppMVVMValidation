package com.ralph.gabb.appmvvmvalidation.util

import android.util.Patterns

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */

// A placeholder username validation check
fun isUserNameValid(username: String): Boolean {
    return if (username.contains('@')) {
        Patterns.EMAIL_ADDRESS.matcher(username).matches()
    } else {
        username.isNotBlank()
    }
}

// A placeholder password validation check
fun isPasswordValid(password: String): Boolean {
    return password.length > 5
}