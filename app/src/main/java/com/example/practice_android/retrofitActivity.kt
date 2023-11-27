package com.example.practice_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.forEach
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class retrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        val serviceKey: String =
            "G5X8eYw30yrZ0hpY426fY1/75Z4LFgEQy3BRkebLRoNfzuQuidqdMCfVgOTtfYAuZwbtiZbKhJZERtB+PSPsPg=="

        val textView: TextView = findViewById(R.id.textView)

        /* val list_view: ListView = findViewById(R.id.list_view)

         //데이터를 담을 itemList
         val itemList: MutableList<String> = ArrayList()
 //데이터를 담는데
         *//*for (i in 1..10){
            itemList.add(i.toString())
        }*//*
//어댑터
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.activity_list_item, itemList)*/

//빌더 생성
        val retrofit =
            Retrofit.Builder().baseUrl("https://apis.data.go.kr/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        //인터페이스 객체생성
        val service =
            retrofit.create(RetrofitService::class.java)
                .getPublicData(
                    serviceKey, "10", "1",
                    "json", "20231126",
                    "1100", "1"
                )
//enqueue로 실행
        service.enqueue(object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {

                if (response.isSuccessful) {
                    val data = response.body()
                    textView.setText(data!!.response.body.items.item[0].baseDate)
                    Log.d("testt", "" + data)
                }
                else{
                    val errorBody = response.errorBody()
                    Log.d("testt", errorBody.toString())
                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("testt", "통신 실패")
                Log.d("testt", ""+ t.localizedMessage)
            }
        })

        /*  list_view.adapter = arrayAdapter*/

    }
}