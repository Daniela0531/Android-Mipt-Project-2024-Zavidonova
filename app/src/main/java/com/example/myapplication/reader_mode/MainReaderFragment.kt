package com.example.myapplication.reader_mode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMainReaderBinding
import com.example.myapplication.reader_mode.recycler.StoryAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.android.schedulers.AndroidSchedulers

// DONE

class MainReaderFragment : Fragment(R.layout.fragment_main_reader) {
    private val viewModel: StoryListViewModel by viewModels()
    private val viewDisposables = CompositeDisposable()
    private val storyReaderAdapter = StoryAdapter()
    private lateinit var storyRecycler: RecyclerView
    private lateinit var button : Button

    private var _binding: FragmentMainReaderBinding? = null
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
        Log.d("main reader fragment","onViewCreated")

        binding.reading.setOnClickListener {
            findNavController().navigate(R.id.action_MainReaderFragment_to_ReadingFragment)
        }

        binding.settings.setOnClickListener {
            findNavController().navigate(R.id.action_MainReaderFragment_to_ReaderSettingsFragment)
        }

        /////////

        Log.d("main reader fragment","newStrings")
        storyRecycler = view.findViewById(R.id.main_reader)
        storyRecycler.adapter = storyReaderAdapter
        storyRecycler.layoutManager = LinearLayoutManager(context)

        button = view.findViewById(R.id.button_to_add_story_to_reader)
        Log.d("main reader fragment","newStrings")
//        viewDisposables.add(
//            viewModel.viewStates()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { viewState->
//                    storyReaderAdapter.items = viewState.items
//                    storyReaderAdapter.notifyDataSetChanged()
//                }
//        )
//        viewDisposables.add(
//            viewModel.viewStates()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { viewState->
//                    storyReaderAdapter.items = viewState.items
//                    storyReaderAdapter.notifyDataSetChanged()
//                }
//        )

        button.setOnClickListener {
            viewModel.getMoreStories()
        }

    }

    override fun onDestroyView() {
        Log.d("main reader fragment","onDestroyView")
        super.onDestroyView()
        _binding = null
        viewDisposables.clear()
    }
}