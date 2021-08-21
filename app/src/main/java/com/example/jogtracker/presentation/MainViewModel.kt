package com.example.jogtracker.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jogtracker.data.network.RetrofitClient
import com.example.jogtracker.data.network.model.Jog
import com.example.jogtracker.data.network.model.LoginRequest
import com.example.jogtracker.data.network.model.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val jogs = MutableLiveData<List<Jog>>()

    fun addJog() {

    }

    fun removeJogById(id: Long) {

    }

    fun updateJog() {

    }

    fun authUser() {
        viewModelScope.launch {
            val response = RetrofitClient.getJogTrackerApi().authUserByUUId(LoginRequest("hello"))
            Log.e("Token ", "$response")
        }
    }

    fun login() {

        viewModelScope.launch {
            val login = LoginRequest("hello")
            val call = RetrofitClient.getJogTrackerApi().authUserByUUId(login)
            call.enqueue(object : Callback<LoginResponse> {

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.e("onResponse success", response.body()?.loginResponse?.token.toString())
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("onFailure", "fail")
                }
            })
        }

    }
}