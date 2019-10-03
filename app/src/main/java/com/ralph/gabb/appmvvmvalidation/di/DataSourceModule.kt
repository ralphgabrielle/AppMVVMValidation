package com.ralph.gabb.appmvvmvalidation.di

import com.ralph.gabb.appmvvmvalidation.data.data_source.LoginDataSource
import com.ralph.gabb.appmvvmvalidation.data.data_source.UserDataSource
import org.koin.dsl.module.module

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */

val dataSourceModule = module {


    factory { LoginDataSource() }


    factory { UserDataSource() }

}