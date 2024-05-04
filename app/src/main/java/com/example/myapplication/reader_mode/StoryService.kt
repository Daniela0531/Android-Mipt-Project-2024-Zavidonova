package com.example.myapplication.reader_mode

import android.widget.Button
import androidx.lifecycle.ViewModel
import com.example.myapplication.databinding.FragmentMainReaderBinding
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.Retrofit
import io.reactivex.Single
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// DONE

@kotlinx.serialization.Serializable
data class Story(
    val story: String,
    val length: Int,
)

interface StoryService {
    @GET("story/")
    fun getStory(): Single<Story>

    @GET("stories/")
    fun getStories(@Query("limit") maxStoriesLimit: Int): Single<List<Story>>
}

object StoryServiceFactory {
    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://pikabu.ru/community/true_story")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()

    fun createStoryService(): StoryService {
        return retrofit.create(StoryService::class.java)
    }
}


