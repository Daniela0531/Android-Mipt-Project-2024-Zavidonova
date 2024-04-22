package com.example.myapplication

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R.layout.activity_main
import com.example.myapplication.databinding.ActivityMainBinding

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(activity_main)
//
//        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
//    }
//}
class MainActivity : AppCompatActivity() {
    lateinit var firstName: EditText
    lateinit var lastName: EditText
    lateinit var mail: EditText
    lateinit var register: Button
    lateinit var about_app: Button
    init {

    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(com.example.myapplication.R.layout.activity_main)
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()


        val intent = Intent(this, ReaderNavigationFragment::class.java)
        firstName = findViewById(com.example.myapplication.R.id.name)
        lastName = findViewById(com.example.myapplication.R.id.last_name)
        mail = findViewById(com.example.myapplication.R.id.mail)
        register = findViewById(com.example.myapplication.R.id.button_registration)

//        about_app =findViewById(com.example.myapplication.R.id.button_to_app_discription_from_reader)
//        about_app.setOnClickListener {
//            startActivity(intent)
//        }
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        Log.d("main activity", "I exist")
    }
    fun onSendData(selectedItem: String?) {
        val fragment: SplashScreenFragment? = supportFragmentManager
            .findFragmentById(R.id.content) as SplashScreenFragment?
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