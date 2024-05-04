package com.example.myapplication.reader_mode.recycler

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMainReaderBinding
import io.reactivex.Single

// DONE

class StoryView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        inflate(context, R.layout.story_view, this)
        layoutParams= LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private val textView = findViewById<TextView>(R.id.story_text_view)

    fun render(viewState: StoryViewState) {
        textView.text = viewState.text
//        imageView.setImageResource(viewState.resId)
    }
}


data class StoryViewState (
    val text: String,
    val resId: Int,
) {
    val items: List<StoryViewState>
        get() {
            TODO()
        }
}

