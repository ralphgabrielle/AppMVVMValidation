package com.ralph.gabb.appmvvmvalidation.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ralph.gabb.appmvvmvalidation.data.FormResult
import com.ralph.gabb.appmvvmvalidation.R
import com.ralph.gabb.appmvvmvalidation.data.model.User
import com.ralph.gabb.appmvvmvalidation.data.repository.user.UserRepository
import com.ralph.gabb.appmvvmvalidation.util.isPasswordValid
import com.ralph.gabb.appmvvmvalidation.util.isUserNameValid

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */
class RegisterViewModel(val userRepository: UserRepository) : ViewModel() {

    private val registerForm = MutableLiveData<RegisterFormState>()
    val registerFormState : LiveData<RegisterFormState> = registerForm

    private val registerResult = MutableLiveData<FormResult<User>>()
    val registerUserResult : LiveData<FormResult<User>> = registerResult

    fun registerTextField(firstName: String, lastName: String, username: String, password: String) {
        if (firstName.isEmpty()) {
            registerForm.value = RegisterFormState(firstNameError = R.string.error_empty_first_name)
            return
        }

        if (lastName.isEmpty()) {
            registerForm.value = RegisterFormState(firstNameError = R.string.error_empty_first_name)
            return
        }

        if (username.isEmpty()) {
            registerForm.value = RegisterFormState(firstNameError = R.string.error_empty_first_name)
            return
        }

        if (password.isEmpty()) {
            registerForm.value = RegisterFormState(firstNameError = R.string.error_empty_first_name)
            return
        }

        if (!isUserNameValid(username)) {
            registerForm.value = RegisterFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            registerForm.value = RegisterFormState(passwordError = R.string.invalid_password)
        } else {
            registerForm.value = RegisterFormState(isDataValid = true)
        }
    }

    fun register(firstName: String, lastName: String, username: String, password: String) {
        registerResult.value = FormResult(success = User(firstName, lastName, username, password))
    }
}