package com.ralph.gabb.appmvvmvalidation.di

import com.ralph.gabb.appmvvmvalidation.ui.login.LoginViewModel
import com.ralph.gabb.appmvvmvalidation.ui.register.RegisterViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Created by Ralph Gabrielle Orden on 9/4/2019.
 */

val viewModelModule = module {

    viewModel { LoginViewModel(get()) }

    viewModel { RegisterViewModel() }
}