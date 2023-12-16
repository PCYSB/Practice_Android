package com.example.practice_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentManger = supportFragmentManager
        val fragmentFirst = FragmentFirst()

        //Transaction 이라는 작업을 한다
        // - 작업의 단위 -> 시작과 끝이 있다

       findViewById<TextView>(R.id.add).setOnClickListener {
           val transaction = fragmentManger.beginTransaction() // 시작
           transaction.replace(R.id.root, fragmentFirst)
           transaction.commit() // 끝

        }

        findViewById<TextView>(R.id.remove).setOnClickListener {
            val transaction = fragmentManger.beginTransaction()
            transaction.remove(fragmentFirst)
            transaction.commit()

        }

        //Commit
        // 1> commit
        // 2> commitAllowingStateLoss

        // 3> commitNow
        // 4> commitNowAllowingNow

    }
}