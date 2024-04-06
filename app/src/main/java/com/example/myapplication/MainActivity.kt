package com.example.myapplication

import android.text.TextUtils
import android.util.Patterns
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var firstName: EditText
    lateinit var lastName: EditText
    lateinit var mail: EditText
    lateinit var register: Button
    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val intent = Intent(this, NavigationActivity::class.java)
        firstName = findViewById(R.id.name)
        lastName = findViewById(R.id.last_name)
        mail = findViewById(R.id.mail)
        register = findViewById(R.id.button_registration)


        register.setOnClickListener {
            startActivity(intent)
        }

    }

    private fun checkDataEntered(): Boolean {
        var isFirstName: Boolean = true
        var isLastName: Boolean = true
        var isMail: Boolean = true

        if (isEmpty(firstName)) {
            isFirstName = false
            val t =
                Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT)
            t.show()
        }
        if (isEmpty(lastName)) {
            isLastName = false
            lastName.error = "Last name is required!";
        }
        if (!isMail(mail)) {
            isMail = false
            mail.error = "Enter valid email!";
        }
        return isFirstName and isLastName and isMail
    }

    private fun isEmpty(text: EditText?): Boolean {
        val str: CharSequence = text!!.text.toString()
        return TextUtils.isEmpty(str)
    }
    private fun isMail(text: EditText?): Boolean {
        val email: CharSequence = text!!.text.toString()
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }
}