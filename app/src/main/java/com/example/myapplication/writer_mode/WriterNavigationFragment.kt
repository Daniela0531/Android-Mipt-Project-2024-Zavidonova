package com.example.myapplication.writer_mode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentWriterNavigationBinding


class WriterNavigationFragment : Fragment() {

    private var _binding: FragmentWriterNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWriterNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToReaderModeFromWriter.setOnClickListener {
            Log.d("registration","let press button")
            findNavController().navigate(R.id.action_WriterNavigationFragment_to_ReaderNavigationFragment)
            Log.d("registration","have pressed button")
        }

        binding.buttonToAppDiscriptionFromWriter.setOnClickListener {
            Log.d("registration","let press button")
            findNavController().navigate(R.id.action_WriterNavigationFragment_to_AboutAppFragment)
            Log.d("registration","have pressed button")
        }
    }
}
