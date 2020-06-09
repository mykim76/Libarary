package com.example.libarary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_large_photo.*

class LargePhotoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_large_photo)
        setValues()
        setupEvents()

    }

    override fun setValues() {
       // Glide.with(mContent).load("http://thumb.mt.co.kr/06/2020/02/2020021308320311046_1.jpg/dims/optimize/").into(profilePhoto)
        Glide.with(mContent).load("http://thumb.mt.co.kr/06/2020/02/2020021308320311046_1.jpg/dims/optimize/").into(photo_view)
    }

    override fun setupEvents() {

    }
}
