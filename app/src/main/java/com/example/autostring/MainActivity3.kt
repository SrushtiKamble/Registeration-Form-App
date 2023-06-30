package com.example.autostring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var tt1 = this.findViewById<TextView>(R.id.tt1)
        var b1 = this.findViewById<TextView>(R.id.b1)
        var submitbtn = this.findViewById<TextView>(R.id.submitbtn)

        object : CountDownTimer(30000, 1000){
        override fun onTick(millisUnitFinised: Long) {
            b1.setText("Seconds Remaining:" + millisUnitFinised / 1000)
        }

        override fun onFinish() {
            tt1.setText("Done")
            b1.setText("Resend OTP")
        }
        }.start()

        submitbtn .setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
                startActivity(intent)

        }
    }
}