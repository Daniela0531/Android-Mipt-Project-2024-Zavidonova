package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSplashScreenBinding

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashScreenFragment : Fragment() {
//    lateinit var firstName: EditText
//    lateinit var lastName: EditText
//    lateinit var mail: EditText
//    lateinit var register: Button
//
    lateinit var about_app: Button
    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegistration.setOnClickListener {
            Log.d("registration","let press button")
            findNavController().navigate(R.id.action_SplashScreenFragment_to_ReaderNavigationFragment)
            Log.d("registration","have pressed button")
        }
//        about_app = findViewById(com.example.myapplication.R.id.button_to_app_discription_from_reader)
//        about_app.setOnClickListener {
//            startActivity(intent)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}