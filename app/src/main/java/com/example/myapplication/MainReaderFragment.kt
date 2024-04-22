package com.example.myapplication

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R.layout.fragment_main_reader
import com.example.myapplication.databinding.FragmentMainReaderBinding


//class MainReaderFragment : Fragment() {
//    private var mListener: OnFragmentInteractionListener? = null
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        Log.d("main reader fragment", "I am created!")
//        return inflater.inflate(fragment_main_reader, container, false)
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        mListener = if (context is OnFragmentInteractionListener) {
//            context
//        } else {
//            throw RuntimeException(
//                context.toString()
//                        + " must implement OnFragmentInteractionListener"
//            )
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        mListener = null
//    }
//
//    interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun messageFromChildFragment(uri: Uri?)
//    }
//}

class MainReaderFragment : Fragment() {
    private var _binding: FragmentMainReaderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("main reader fragment","Hello! I am here")
        _binding = FragmentMainReaderBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reading.setOnClickListener {
            findNavController().navigate(R.id.action_MainReaderFragment_to_ReadingFragment)
        }

        binding.settings.setOnClickListener {
            findNavController().navigate(R.id.action_MainReaderFragment_to_ReaderSettingsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}