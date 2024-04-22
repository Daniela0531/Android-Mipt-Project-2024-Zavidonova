package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentReadingBinding
import com.example.myapplication.databinding.FragmentWriterSettingsBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WriterSettingsFragment : Fragment() {

    private var _binding: FragmentWriterSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWriterSettingsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonStories.setOnClickListener {
            findNavController().navigate(R.id.action_WriterSettingsFragment_to_MainWriterFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}