package com.ralph.gabb.appmvvmvalidation.di

import com.ralph.gabb.appmvvmvalidation.data.repository.LoginRepository
import com.ralph.gabb.appmvvmvalidation.data.repository.user.UserRepository
import com.ralph.gabb.appmvvmvalidation.data.repository.user.UserRepositoryImpl
import org.koin.dsl.module.module

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */

val repositoryModule = module {

    factory { LoginRepository(get()) }

    factory<UserRepository> { UserRepositoryImpl(get()) }

}