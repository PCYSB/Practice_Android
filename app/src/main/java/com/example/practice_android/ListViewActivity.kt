package com.example.practice_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val textView: TextView = findViewById(R.id.textView)

        textView.setOnClickListener {
            val popUpMenu = PopupMenu(applicationContext, it)

            menuInflater?.inflate(R.menu.popup_menu, popUpMenu.menu)
            popUpMenu.show()
            popUpMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.popup1 -> {
                        Toast.makeText(applicationContext, ",첫번째 클릭", Toast.LENGTH_LONG).show()
                        return@setOnMenuItemClickListener true
                    }

                    else -> return@setOnMenuItemClickListener false
                }

            }
        }


    }
}

