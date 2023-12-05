package com.example.practice_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.scwang.wave.MultiWaveHeader


class WaveView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wave_view)

        var wave_header: MultiWaveHeader
        wave_header=findViewById(R.id.wave_header);
        wave_header.setVelocity(10F)
        wave_header.setProgress(1F)
        wave_header.isRunning()
        wave_header.setGradientAngle(45)
        wave_header.setWaveHeight(40)


    }

}