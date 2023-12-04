package com.example.practice_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog


class LoginActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        listView = findViewById(R.id.list_view)

        val emailDomains = arrayOf("gmail.com", "naver.com", "daum.net")

        val data = arrayOf("gmail.com", "User 2", "User 3", "User 4", "User 5")
        val dataList = ArrayList(data.toList())

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, _, _ ->
            showEmailDomainDialog()
        }
    }
    fun showEmailDomainDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select Email Domain")
        builder.setMessage("Choose an email domain")

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        // Create and show the dialog
        val dialog = builder.create()
        dialog.show()
    }


}