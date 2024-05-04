package com.example.myapplication.reader_mode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.reader_mode.recycler.StoryViewState
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

class StoryListViewModel : ViewModel() {

//    fun viewStates(): Observable<StoryListViewState> =
//        storyRepository.storyListObservable.map { storyList ->
//            val storyViewStateList = storyList.map {
//                StoryViewState(
//                    text = it.story,
//                )
//            }
//            StoryListViewState(storyViewStateList)
//        }
//    fun viewStates(): Observable<StoryViewState> = viewStatesSubject

    private val disposables = CompositeDisposable()
    private val storyService = StoryServiceFactory.createStoryService()
    private val storyRepository = StoryRepository(storyService)
//    private val viewStatesSubject = BehaviorSubject

    fun getMoreStories () {
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
                return StoryListViewModel() as T
            }
        }
    }

//    fun viewStates(): Observable<StoryListViewState> =
//        storyRepository.storyListObservable.map { storyList ->
//            val viewStates = storyList.map {
//                StoryViewState(
//                    text = it.story,
//                )
//            }
//            StoryListViewState(viewStates.map {StoryViewState(text = it.story)})
//        }
}

class StoryListViewState(
    val items: List<StoryViewState>,
    val diffResult: DiffUtil.DiffResult,

    )