package com.example.practice_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract

class emailList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_list)

        val emailList = mutableListOf<String>()
        emailList.add(0, "gmail.com")


    }
}

