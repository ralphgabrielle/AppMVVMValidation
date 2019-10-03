package com.ralph.gabb.appmvvmvalidation.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Ralph Gabrielle Orden on 10/3/2019.
 */
abstract class BaseActivity : AppCompatActivity() {

    @get:LayoutRes
    protected abstract val layoutId: Int?

    protected abstract fun viewCreated()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutId?.let {
            setContentView(it)
        }

        viewCreated()
    }

}