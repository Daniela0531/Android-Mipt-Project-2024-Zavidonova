package com.example.myapplication.reader_mode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentReaderSettingsBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ReaderSettingsFragment : Fragment() {

    private var _binding: FragmentReaderSettingsBinding? = null
    private lateinit var switchTheme: Switch
    private lateinit var textView: Switch

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentReaderSettingsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonStories.setOnClickListener {
            findNavController().navigate(R.id.action_ReaderSettingsFragment_to_MainReaderFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}