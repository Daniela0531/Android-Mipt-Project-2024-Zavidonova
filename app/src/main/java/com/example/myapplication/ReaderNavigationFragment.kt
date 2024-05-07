package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentReaderNavigationBinding

class ReaderNavigationFragment : Fragment() {

    private var _binding: FragmentReaderNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReaderNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonToWriterModeFromReader.setOnClickListener {
//            Log.d("registration","let press button")
//            findNavController().navigate(R.id.action_ReaderNavigationFragment_to_WriterNavigationFragment)
//            Log.d("registration","have pressed button")
//        }
//
//        binding.buttonToAppDiscriptionFromReader.setOnClickListener {
//            Log.d("registration","let press button")
//            findNavController().navigate(R.id.action_ReaderNavigationFragment_to_AboutAppFragment)
//            Log.d("registration","have pressed button")
//        }
    }
}