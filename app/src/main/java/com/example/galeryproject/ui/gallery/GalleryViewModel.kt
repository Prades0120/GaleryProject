package com.example.galeryproject.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.galeryproject.Tarjeta

class GalleryViewModel : ViewModel() {

    private val _content = MutableLiveData<ArrayList<Tarjeta>>().apply {
        val items = ArrayList<Tarjeta>(0)

        value = items

    }
    val content: LiveData<ArrayList<Tarjeta>>? = _content
}