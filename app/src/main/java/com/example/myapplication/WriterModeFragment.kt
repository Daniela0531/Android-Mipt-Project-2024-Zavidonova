package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentWriterModeBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class WriterModeFragment : Fragment() {

    private var _binding: FragmentWriterModeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWriterModeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toWrite.setOnClickListener {
            findNavController().navigate(R.id.action_WriterModeFragment_to_WritingStoryFragment)
        }

        binding.writerSettings.setOnClickListener {
            findNavController().navigate(R.id.action_WriterModeFragment_to_WriterSettingsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}