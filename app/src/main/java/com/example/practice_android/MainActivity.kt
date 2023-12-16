package com.example.practice_android

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        textView.setOnClickListener {
            val popUpMenu = PopupMenu(applicationContext, it).setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.popup1 ->{
                        Toast.makeText(applicationContext, "1번 클릭", Toast.LENGTH_LONG).show()
                        return@setOnMenuItemClickListener true
                    }

                    else -> return@setOnMenuItemClickListener false


                }
            }
        }




    }
}