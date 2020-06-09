package com.example.libarary

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {

    val mContent = this
    abstract fun setValues()
    abstract fun setupEvents()
}