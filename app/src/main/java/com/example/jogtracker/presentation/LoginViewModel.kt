package com.example.jogtracker.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jogtracker.data.network.retrofit.RetrofitClient
import com.example.jogtracker.data.repository.NetworkRepositoryImpl
import com.example.jogtracker.domain.LoginInteractorImpl
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val loginInteractor =
        LoginInteractorImpl(NetworkRepositoryImpl(RetrofitClient.getJogTrackerApi()))

    val tokenHolder = MutableLiveData<String?>()

    fun loginByUUID(uuid: String) {
        viewModelScope.launch {
            tokenHolder.value = loginInteractor.loginByUUID(uuid)
        }
    }
}