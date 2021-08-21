package com.example.jogtracker.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.jogtracker.R
import com.example.jogtracker.data.network.model.LoginResponse
import com.example.jogtracker.data.network.model.LoginRequest
import com.example.jogtracker.data.network.RetrofitClient
import com.example.jogtracker.data.network.SessionManager
import com.example.jogtracker.data.network.model.JogsResponse
import com.example.jogtracker.presentation.fragments.MainFragment
import com.example.jogtracker.presentation.utils.openFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private var token: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = SessionManager(this)

        getToken()
        // getJogs()
        openFragment(
            supportFragmentManager,
            R.id.activity_fragment_container,
            MainFragment.newInstance(),
            true
        )
    }

    override fun onResume() {
        super.onResume()
        val viewModel = MainViewModel()
        viewModel.authUser()
    }

    private fun getToken() {
        RetrofitClient.getJogTrackerApi(this).authUserByUUId(LoginRequest("hello")).enqueue(
            object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("onFailure", "Error logging in")
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()

                    if (response.isSuccessful && loginResponse?.accessToken != null) {
                        sessionManager.saveToken(loginResponse.accessToken)
                        Log.e("Token", loginResponse.accessToken)
                        Log.e("Token", response.toString())
                    } else {
                        Log.e("onResponse", "Error logging in")
                        Log.e("Token", response.toString())
                        Log.e("Token", loginResponse?.accessToken.toString())
                    }
                }
            }
        )
    }

    private fun getJogs() {

        // Pass the token as parameter
        RetrofitClient.getJogTrackerApi(this)
            .fetchPosts(token = "Bearer ${sessionManager.fetchAuthToken()}")
            .enqueue(object : Callback<JogsResponse> {
                override fun onFailure(call: Call<JogsResponse>, t: Throwable) {
                    Log.e("jogs", "Get jogs error  ")
                }

                override fun onResponse(
                    call: Call<JogsResponse>,
                    response: Response<JogsResponse>
                ) {
                    Log.e("jogs", "jogs received   ")
                    Log.e("jogs", response.toString())
                }
            })
    }


}