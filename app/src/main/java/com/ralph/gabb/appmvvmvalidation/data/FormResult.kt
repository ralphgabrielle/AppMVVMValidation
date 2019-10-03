package com.ralph.gabb.appmvvmvalidation.data

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */
data class FormResult<out T> (
    val success: T? = null,
    val error: Int? = null
)
