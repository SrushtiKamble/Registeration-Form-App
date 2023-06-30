package com.example.autostring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val dbHelper = DBHelper(applicationContext)
        val verifybtn = this.findViewById<Button>(R.id.verifybtn)
        val otpbtn = this.findViewById<Button>(R.id.otpbtn)
        val otpbox = this.findViewById<TextView>(R.id.otpbox);

        fun verify(): Boolean? {
            val phonebox = this.findViewById<TextView>(R.id.phonebox);
            val emailbox = this.findViewById<TextView>(R.id.emailbox);
            return dbHelper.verifyUser(
                phonebox.text.toString(),
                emailbox.text.toString(),
            )
        }
        fun generateRandomNumber(): Int {
            val randomNumber = Random.nextInt(100000, 999999)
            return randomNumber
        }

        otpbtn.setOnClickListener{
            val number = generateRandomNumber()
            otpbox.setText(number.toString())
        }

        verifybtn .setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            if(verify()==true) {
                Toast.makeText(applicationContext, "Mobile Number Verified", Toast.LENGTH_SHORT)
                    .show()
                startActivity(intent)
            }
            else Toast.makeText(applicationContext, "Invalid Mobile Number", Toast.LENGTH_SHORT)
                .show()

        }
    }

}
