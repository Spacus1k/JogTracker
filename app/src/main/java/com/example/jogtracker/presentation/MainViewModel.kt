package com.example.jogtracker.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jogtracker.data.network.model.Jog
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val jogs = MutableLiveData<List<Jog>>()

    fun addJog(){

    }

    fun removeJogById(id:Long){

    }

    fun updateJog(){

    }

    fun authUser(){
        viewModelScope.launch {
           //val response =  RetrofitClient.getJogTrackerApi().authUserByUUId("hello")
           // Log.e("Token ", "$response")
        }
    }
}