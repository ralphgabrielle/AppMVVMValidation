package com.ralph.gabb.appmvvmvalidation

import android.app.Application
import com.ralph.gabb.appmvvmvalidation.di.appModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */
class ValidationApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        plantDebugTree()
        configureDependencyInjection()
    }

    private fun plantDebugTree() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun configureDependencyInjection() {
        startKoin(this, appModule)
    }

}