package com.example.priyanshrajput.userlist

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface  ApiMethos {
    @GET("users.json")//{x-API-Key: 920c9fc0}
    fun getUsers(@Header("x-API-Key") authorization: String): Call<ResponseBase>
}