package com.example.jogtracker.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jogtracker.data.network.model.response.Jog
import com.example.jogtracker.data.network.retrofit.RetrofitClient
import com.example.jogtracker.data.repository.NetworkRepositoryImpl
import com.example.jogtracker.domain.JogTrackerInteractorImpl
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val jogs = MutableLiveData<List<Jog>>()
    private val interactor =
        JogTrackerInteractorImpl(NetworkRepositoryImpl(RetrofitClient.getJogTrackerApi()))

    init{
        loadJogsList()
    }

    fun addJog() {

    }

    fun removeJogById(id: Int) {

    }

    fun updateJog() {

    }

     fun loadJogsList(){
        viewModelScope.launch {
            jogs.value = interactor.getJogs()
                //Log.e("TAG","View Model get jogs" )
            Log.e("Live data ", "${jogs.value}")
        }
    }

    fun getJogs(){
        viewModelScope.launch {

        }
    }



 /*   suspend fun withJob(context: Context) = coroutineScope {
        val job = launch {
            login(context)
            delay(10000L)
        }

        job.join()

        getJogs(context)
    }*/

    /*  private fun getUser(context: Context) {
          val sessionManager = SessionManager(context)
          RetrofitClient.getJogTrackerApi(context)
              .getCurrentUser(token = "Bearer ${sessionManager.fetchAuthToken()}")
              .enqueue(object : Callback<UserResponseObj>{
                  override fun onResponse(
                      call: Call<UserResponseObj>,
                      response: Response<UserResponseObj>
                  ) {
                      if (response.isSuccessful) {
                          Log.e("User onResponse success", response.body().toString())
                      } else {
                          Log.e("User onResponse fail", response.toString())
                      }
                  }
                  override fun onFailure(call: Call<UserResponseObj>, t: Throwable) {
                      Log.e("Failure user", "error")
                  }
              })
      }*/

    /* private fun login(context: Context) {
         val sessionManager = SessionManager(context)
         RetrofitClient.getJogTrackerApi(context).authUserByUUId(LoginRequest("hello"))
             .enqueue(object : Callback<LoginResponseObj> {

                 override fun onResponse(
                     call: Call<LoginResponseObj>,
                     response: Response<LoginResponseObj>
                 ) {
                     val token = response.body()?.loginResponse?.token

                     if (response.isSuccessful && token != null) {

                         sessionManager.saveAuthToken(token)
                         Log.e(
                             "Response success login",
                             response.body()?.loginResponse?.token.toString()
                         )
                     } else {
                         Log.e(
                             "Response success login",
                             response.body().toString()
                         )
                     }
                 }
                 override fun onFailure(call: Call<LoginResponseObj>, t: Throwable) {
                     Log.e("onFailure login", "fail")
                 }
             })
     }*/

    /*private fun getJogs(context: Context) {

        val sessionManager = SessionManager(context)
        RetrofitClient.getJogTrackerApi(context)
            .getJogsList()
            .enqueue(object : Callback<JogsAndUsersResponse> {

                override fun onResponse(
                    call: Call<JogsAndUsersResponse>,
                    andUsersResponse: Response<JogsAndUsersResponse>
                ) {
                    if (andUsersResponse.isSuccessful) {
                        Log.e("Jogs onResponse success", andUsersResponse.body().toString())
                    } else {
                        Log.e("Jogs onResponse fail", andUsersResponse.toString())
                    }
                }

                override fun onFailure(call: Call<JogsAndUsersResponse>, t: Throwable) {
                    Log.e("Failure jogs", "fail jogs")
                }
            })
    }*/

}