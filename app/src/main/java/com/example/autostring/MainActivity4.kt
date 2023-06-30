package com.example.autostring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val textView = this.findViewById<TextView>(R.id.wlcbox)
        textView.text = "Welcome You have Successfully registered in AutoString"
    }
}