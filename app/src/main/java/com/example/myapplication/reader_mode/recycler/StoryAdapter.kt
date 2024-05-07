package com.example.myapplication.reader_mode.recycler

import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentMainReaderBinding
import com.example.myapplication.reader_mode.StoryListViewState
import io.reactivex.Single

// DONE

class StoryAdapter : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    var items: List<StoryViewState> = emptyList()
    class ViewHolder(val view: StoryView) : RecyclerView.ViewHolder(view)

//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(StoryView(ViewGroup.context))
//    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.view.render(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = items.size
}


