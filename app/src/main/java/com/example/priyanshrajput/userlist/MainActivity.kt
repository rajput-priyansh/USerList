package com.example.priyanshrajput.userlist

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import BaseModel
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    private val listUser: ArrayList<BaseModel> = ArrayList<BaseModel>()

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        initUI()

    }

    fun initData() {
        viewModel = MainViewModel();
    }

    fun initUI() {
        viewModel.getUsers()

        val rvUser = findViewById<RecyclerView>(R.id.rvUser)

        rvUser.layoutManager = LinearLayoutManager(this)


        adapter = UserAdapter(listUser, this, object : ItemClick {
            override fun itemSelect(user: BaseModel) {
                val intent: Intent = Intent( this@MainActivity, DetailActivity::class.java)
                intent.putExtra("User", Gson().toJson(user))
                startActivity(intent)
            }

        })


        viewModel.requestUser.observe(this, Observer<ArrayList<BaseModel>>{ users ->

            //Update the adapter
            listUser.clear()
            if (users != null) {
                listUser.addAll(users)
                adapter.notifyDataSetChanged()
            }
        })
    }


}
