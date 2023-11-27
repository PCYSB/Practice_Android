package com.example.practice_android

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url



data class Weather (
    val response: ResponseData
)


data class ResponseData (
    val header: Header,
    val body: Body
)


data class Body (
    val dataType: String,
    val items: Items,
    val pageNo: Long,
    val numOfRows: Long,
    val totalCount: Long
)


data class Items (
    val item: List<Item>
)


data class Item (
    val beachNum: String,
    val baseDate: String,
    val baseTime: String,
    val category: String,
    val fcstDate: String,
    val fcstTime: String,
    val fcstValue: String,
    val nx: Long,
    val ny: Long
)


data class Header (
    val resultCode: String,
    val resultMsg: String
)



interface RetrofitService {
    @GET("1360000/BeachInfoservice/getUltraSrtFcstBeach")
    fun getPublicData(

        @Query("serviceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: String,
        @Query("pageNo") pageNo: String,
        @Query("dataType") dataType: String,
        @Query("base_date") base_date: String,
        @Query("base_time") base_time: String,
        @Query("beach_num") beach_num: String
    ): Call<Weather>


}