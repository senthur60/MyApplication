package com.example.myapplication

import android.animation.ValueAnimator
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val canvasView = findViewById<CanvasView>(R.id.canvasView)
        val animation = ValueAnimator.ofFloat(0.0f, 1.0f)
        animation.addUpdateListener { animation ->
            val value = animation.animatedValue as Float
            canvasView.value=value
            canvasView.invalidate()
        }
        animation.duration =  1000
        animation.repeatMode=ValueAnimator.RESTART
        animation.repeatCount=ValueAnimator.INFINITE
        animation.start()


    }
}
