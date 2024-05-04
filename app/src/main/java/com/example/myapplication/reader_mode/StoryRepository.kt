package com.example.myapplication.reader_mode

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.schedulers.Schedulers

// DONE

class StoryRepository(
    val storyService: StoryService,
) {
    private val currentStoryList: BehaviorSubject<List<Story>> = BehaviorSubject.createDefault(
        emptyList()
    )

    val storyListObservable: Observable<List<Story>> = currentStoryList

    fun loadStory(): Disposable {
        return storyService.getStory()
            .subscribeOn(Schedulers.io())
            .subscribe { story ->
                val newList = currentStoryList.value!!.toMutableList() + story
                currentStoryList.onNext(newList)
            }
    }
}