package com.example.priyanshrajput.userlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import BaseModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val _requestUser = MutableLiveData<ArrayList<BaseModel>>()
    val requestUser: MutableLiveData<ArrayList<BaseModel>>   = _requestUser


    fun getUsers() {
        val api = ApiService().createService()
        api.getUsers("920c9fc0").enqueue(object : Callback<ResponseBase> {
            override fun onResponse(call: Call<ResponseBase>, response: Response<ResponseBase>) {
                val res = response.body()
                if (res != null) {

                    _requestUser.setValue(res.users as ArrayList<BaseModel>?)
                } else {
                    _requestUser.setValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseBase>, t: Throwable) {
                _requestUser.setValue(null)
            }
        })
    }
}