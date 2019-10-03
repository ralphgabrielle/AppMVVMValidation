package com.ralph.gabb.appmvvmvalidation.ui.register

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */
data class RegisterFormState(

    val firstNameError: Int? = null,
    val lastNameError: Int? = null,
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false

)