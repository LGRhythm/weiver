package com.rhythm.rwv.viewmodel

import android.databinding.ObservableField
import com.rhythm.rwv.model.Animal

class AnimalViewModel(val animal : Animal) {

    val info = ObservableField<String>("${animal.name} 叫了 ${animal.shoutCount} 声..")

    fun shout() {
        animal.shoutCount++
        info.set("${animal.name} 叫了 ${animal.shoutCount} 声..")
    }
}