package com.example.libarary

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.security.Permission

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

        Glide.with(mContent).load("http://thumb.mt.co.kr/06/2020/02/2020021308320311046_1.jpg/dims/optimize/").into(profilePhoto)
    }

    override fun setupEvents() {

        profilePhoto.setOnClickListener {

            val myIntent = Intent(mContent,LargePhotoActivity::class.java)
            startActivity(myIntent)
        }

        btnCall.setOnClickListener {
//
//            PermissionListener permissionlistener = new PermissionListener() {
//                @Override
//                public void onPermissionGranted() {
//                    Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onPermissionDenied(List<String> deniedPermissions) {
//                    Toast.makeText(MainActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
//                }
//
//
//            };

            val pl = object :PermissionListener{
                override fun onPermissionGranted() {
                        //허가가 나면 실행할 내용 => 전화걸기
                    val myUri = Uri.parse("tel:${phonNumTxt.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    //거부되면 실행할 내용
                    Toast.makeText(mContent,"전화 권한이 거부되어 통화 불가",Toast.LENGTH_SHORT).show()
                }

            }

//            TedPermission.with(this)
//                .setPermissionListener(permissionlistener)
//                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
//                .setPermissions(Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION)
//                .check();
            TedPermission.with(mContent)
                .setPermissionListener(pl)
                .setDeniedMessage("권한을 거부하면 통화 할 수 없습니다.[설정]>[권한]에서 권한설정 해주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }
    }
}
