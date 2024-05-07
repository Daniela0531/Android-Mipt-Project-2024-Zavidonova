package com.example.myapplication.reader_mode

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.reader_mode.recycler.StoryViewState
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class StoryListViewModel : ViewModel() {

    fun viewStates(): Observable<StoryListViewState> =
        storyRepository.storyListObservable.map { storyList ->
            val storyViewStateList = storyList.map {
                StoryViewState(
                    text = it.text,
//                    resId = 1,
                )
            }
            StoryListViewState(storyViewStateList)
        }

    private val disposables = CompositeDisposable()
    private val storyService = StoryServiceFactory.createStoryService()
    private val storyRepository = StoryRepository(storyService)


    fun getMoreStories () {
        Log.d("getMoreStories", "disposables.add")
        disposables.add(storyRepository.loadStory())
    }

    override fun onCleared() {
        disposables.clear()
    }

    companion object {
        fun factory(storyRepository: StoryRepository): ViewModelProvider.Factory= object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                Log.d("factory", "I am here")
                return StoryListViewModel() as T
            }
        }
    }


}

class StoryListViewState(
    val items: List<StoryViewState>,
)