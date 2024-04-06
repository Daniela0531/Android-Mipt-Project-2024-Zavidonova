package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.myapplication.databinding.ActivityWriterModeBinding

class WriterNavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWriterModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWriterModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toAppActivityIntent = Intent(this, AboutAppActivity::class.java)
        val toReaderModeActivityIntent = Intent(this, NavigationActivity::class.java)

        findViewById<Button>(R.id.button_to_app_discription_from_writer).setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(view: View?) {
                    startActivity(toAppActivityIntent)
                }
            }
        )

        findViewById<Button>(R.id.button_to_reader_mode_from_writer).setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(view: View?) {
                    startActivity(toReaderModeActivityIntent)
                }
            }
        )

    }
}