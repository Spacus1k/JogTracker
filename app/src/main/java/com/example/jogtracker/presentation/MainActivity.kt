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
        viewModel.login()
    }



}