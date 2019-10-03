package com.ralph.gabb.appmvvmvalidation.ui.login

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.annotation.StringRes
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.ralph.gabb.appmvvmvalidation.R
import com.ralph.gabb.appmvvmvalidation.ex.afterTextChanged
import com.ralph.gabb.appmvvmvalidation.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private val loginViewModel: LoginViewModel by viewModel()

    override val layoutId: Int?
        get() = R.layout.activity_login

    override fun viewCreated() {
        observeLoginFormState()
        observeLoginResult()

        addTextEventListeners()
        buttonClickListener()
    }

    private fun buttonClickListener() {
        login.setOnClickListener {
            loading.visibility = View.VISIBLE
            loginViewModel.login(username.text.toString(), password.text.toString())
        }
    }

    private fun addTextEventListeners() {
        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                username.text.toString(),
                password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            username.text.toString(),
                            password.text.toString()
                        )
                }
                return@setOnEditorActionListener false
            }
        }
    }

    private fun observeLoginResult() {
        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            setResult(Activity.RESULT_OK)

            //Complete and destroy login activity once successful
            finish()
        })
    }

    private fun observeLoginFormState() {
        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }

            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
            applicationContext,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}

