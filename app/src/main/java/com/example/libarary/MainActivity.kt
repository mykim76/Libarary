package com.example.libarary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()
    }

    override fun setValues() {

        //ImageView imageView = (ImageView) findViewById(R.id.my_image_view);

        //Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);

        Glide.with(mContent).load("https://thumb.mt.co.kr/06/2020/02/2020021308320311046_1.jpg/dims/optimize/").into(profilePhoto)
    }

    override fun setupEvents() {

        profilePhoto.setOnClickListener {

            val myIntent = Intent(mContent,LargePhotoActivity::class.java)
            startActivity(myIntent)
        }
    }
}
