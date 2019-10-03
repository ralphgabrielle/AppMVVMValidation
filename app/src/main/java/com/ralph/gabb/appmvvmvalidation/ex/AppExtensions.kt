package com.ralph.gabb.appmvvmvalidation.ex

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */


/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}

fun TextView.plainText() = this.text.toString()