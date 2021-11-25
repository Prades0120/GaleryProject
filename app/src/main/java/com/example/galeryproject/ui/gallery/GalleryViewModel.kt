package com.example.galeryproject.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.galeryproject.R
import com.example.galeryproject.Tarjeta

class GalleryViewModel : ViewModel() {

    private val _content = MutableLiveData<ArrayList<Tarjeta>>().apply {
        val items = ArrayList<Tarjeta>(0)
        items.add(Tarjeta("Card 1", R.drawable.image1))
        items.add(Tarjeta("Card 2", R.drawable.image2))
        items.add(Tarjeta("Card 3", R.drawable.image3))
        items.add(Tarjeta("Card 4", R.drawable.image4))
        items.add(Tarjeta("Card 5", R.drawable.image5))
        items.add(Tarjeta("Card 6", R.drawable.image6))
        items.add(Tarjeta("Card 7", R.drawable.image7))
        items.add(Tarjeta("Card 8", R.drawable.image8))
        items.add(Tarjeta("Card 9", R.drawable.image9))

        value = items

    }
    val content: LiveData<ArrayList<Tarjeta>> = _content
}