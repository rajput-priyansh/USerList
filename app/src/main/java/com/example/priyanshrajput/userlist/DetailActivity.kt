package com.example.priyanshrajput.userlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import BaseModel

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvFname = findViewById<TextView>(R.id.tvFname)
        val tvLname = findViewById<TextView>(R.id.tvLname)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvGender = findViewById<TextView>(R.id.tvGender)
        val tvAddress = findViewById<TextView>(R.id.tvAddress)
        val tvImage = findViewById<ImageView>(R.id.tvImage)

        val strUSer = intent.getStringExtra("User")

        val item: BaseModel = Gson().fromJson(strUSer, BaseModel::class.java)

        tvFname.setText(item.first_name)
        tvLname.setText(item.last_name)
        tvEmail.setText(item.email)
        tvGender.setText(item.gender)
        tvAddress.setText(item.address)

        Glide.with(this)
                .load(item.profile_image)
                .centerCrop()
                .into(tvImage);
    }
}