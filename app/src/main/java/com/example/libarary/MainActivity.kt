package com.example.libarary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()
    }

    override fun setValues() {

    }

    override fun setupEvents() {

        profilePhoto.setOnClickListener {

            val myIntent = Intent(mContent,LargePhotoActivity::class.java)
            startActivity(myIntent)
        }
    }
}
