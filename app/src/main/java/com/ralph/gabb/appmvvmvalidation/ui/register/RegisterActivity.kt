package com.ralph.gabb.appmvvmvalidation.ui.register

import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import com.ralph.gabb.appmvvmvalidation.R
import com.ralph.gabb.appmvvmvalidation.ex.afterTextChanged
import com.ralph.gabb.appmvvmvalidation.ex.plainText
import com.ralph.gabb.appmvvmvalidation.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.loading
import kotlinx.android.synthetic.main.activity_register.password
import kotlinx.android.synthetic.main.activity_register.username
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */
class RegisterActivity : BaseActivity() {

    private val viewModel: RegisterViewModel by viewModel()

    override val layoutId: Int?
        get() = R.layout.activity_register

    override fun viewCreated() {
        observeRegisterFormState()
        observeRegisterResult()
        addTextEventListener(firstName, lastName, username, password)
        buttonClickListener()
    }

    private fun observeRegisterResult() {

    }

    private fun buttonClickListener() {
        register.setOnClickListener {
            loading.visibility = View.VISIBLE

            viewModel.register(
                firstName.plainText(), lastName.plainText(),
                username.plainText(), password.plainText()
            )
        }
    }

    private fun observeRegisterFormState() {
        viewModel.registerFormState.observe(this, Observer {
            val formState = it?: return@Observer

            register.isEnabled = formState.isDataValid

            formState.firstNameError?.let { errorId ->
                firstName.error = getString(errorId)
            }

            formState.lastNameError?.let { errorId ->
                lastName.error = getString(errorId)
            }

            formState.usernameError?.let { errorId ->
                username.error = getString(errorId)
            }

            formState.passwordError?.let { errorId ->
                password.error = getString(errorId)
            }
        })
    }

    private fun addTextEventListener(vararg editTexts: EditText) {
        for (field in editTexts) {
            field.afterTextChanged {
                viewModel.registerTextField(firstName.plainText(), lastName.plainText(),
                    username.plainText(), password.plainText())
            }
        }
    }
}