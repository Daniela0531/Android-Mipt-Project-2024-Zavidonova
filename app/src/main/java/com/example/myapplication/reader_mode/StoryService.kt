package com.example.myapplication.reader_mode

import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.Retrofit
import io.reactivex.Single
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// DONE

@Serializable
data class Story(val text: String)

interface StoryService {
    @GET("fact/")
    fun getStory(): Single<Story>

    @GET("facts/")
    fun getStories(@Query("limit") maxStoriesLimit: Int): Single<List<Story>>
}

object StoryServiceFactory {
    @OptIn(UnstableDefault::class)
    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    fun createStoryService(): StoryService {
        Log.d("createStoryService", "I am here")
        return retrofit.create(StoryService::class.java)
    }
}


