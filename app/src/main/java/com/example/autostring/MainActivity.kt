package com.example.autostring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = DBHelper(applicationContext)
        val registerbtn = this.findViewById<Button>(R.id.verifybtn);

        fun register(): Boolean? {
            val fname = this.findViewById<EditText>(R.id.namebox2);
            val lname = this.findViewById<EditText>(R.id.namebox);

            val housebox = this.findViewById<EditText>(R.id.housebox);
            val citybox = this.findViewById<EditText>(R.id.citybox);
            val statebox = this.findViewById<EditText>(R.id.statebox);
            val pinbox = this.findViewById<EditText>(R.id.pinbox);

            val modelbox = this.findViewById<EditText>(R.id.modelbox);
            val yearbox = this.findViewById<EditText>(R.id.yearbox);
            val manubox = this.findViewById<EditText>(R.id.manubox);

            return dbHelper.registerUser(
                fname.text.toString(),
                lname.text.toString(),
                housebox.text.toString(),
                citybox.text.toString(),
                statebox.text.toString(),
                pinbox.text.toString(),
                modelbox.text.toString(),
                yearbox.text.toString(),
                manubox.text.toString()
            );
        }
            registerbtn.setOnClickListener {
                var intent = Intent(this, MainActivity2::class.java)
                if (register() == true) {
                    Toast.makeText(
                        applicationContext,
                        "Successfully Registered",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(intent)
                }
                else Toast.makeText(applicationContext, "Unable to register!", Toast.LENGTH_SHORT)
                    .show()

            }
        }
    }



