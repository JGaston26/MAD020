package com.example.mad20

import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imageCarousel: ImageView = findViewById(R.id.imageView)
        val changeImageButton: Button = findViewById(R.id.changeImageButton)

        val imageList: IntArray = intArrayOf(
            R.drawable.hocus_pocus,
            R.drawable.summerween,
            R.drawable.scardeypants,
            R.drawable.girl_vs_monster)

        var count: Int = 0;
        changeImageButton.setOnClickListener {
            count++;
            if (count == 4) {
                count = 0
            }
            println(count)
            imageCarousel.setImageResource(imageList.get(count))
        }

        var timeCount : Int = 0;
        val handler : Handler = Handler(Looper.getMainLooper())
        var runnable : Runnable = Runnable { }
        runnable = Runnable {
            timeCount++;
            if(timeCount.mod(5) == 0 && timeCount != 1){
                count++
                if (count == 4) {
                    count = 0
                }
                imageCarousel.setImageResource(imageList.get(count))
            }
            handler.postDelayed(runnable,1000)
            println(timeCount)
            }
        handler.postDelayed(runnable,1000)


        println(count)

    }
}