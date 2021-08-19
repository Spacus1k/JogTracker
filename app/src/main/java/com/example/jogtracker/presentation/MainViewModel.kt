package com.example.jogtracker.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jogtracker.domain.Jog

class MainViewModel: ViewModel() {

    val jogs = MutableLiveData<List<Jog>>()

    fun addJog(){

    }

    fun removeJogById(id:Long){

    }

    fun updateJog(){

    }
}