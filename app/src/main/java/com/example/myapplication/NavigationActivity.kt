package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.myapplication.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toAppActivityIntent = Intent(this, AboutAppActivity::class.java)
        val toWriterModeActivityIntent = Intent(this, WriterNavigationActivity::class.java)

        findViewById<Button>(R.id.button_to_app_discription_from_reader).setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(view: View?) {
                    startActivity(toAppActivityIntent)
                }
            }
        )

        findViewById<Button>(R.id.button_to_writer_mode_from_reader).setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(view: View?) {
                    startActivity(toWriterModeActivityIntent)
                }
            }
        )

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}