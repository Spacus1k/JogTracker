package com.example.jogtracker.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jogtracker.databinding.ActivityLoginBinding
import com.example.jogtracker.presentation.viewModel.LoginViewModel
import com.example.jogtracker.presentation.utils.UIConstants
import com.example.jogtracker.presentation.utils.showToast
import com.example.jogtracker.presentation.utils.startNewActivity

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private val loginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
        initObservers()
    }

    private fun initButton() {
        binding.loginButton.setOnClickListener {
            loginViewModel.loginByUUID(binding.uuidEditText.text.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        binding.loginButton.performClick()
    }

    private fun initObservers() {
        loginViewModel.tokenHolder.observe(this) { tokenHolder ->
            if (tokenHolder != UIConstants.ERROR) {

                startNewActivity(
                    applicationContext,
                    MainActivity::class.java,
                    arrayOf(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            } else {
                showToast(UIConstants.UUID_INVALID, Toast.LENGTH_SHORT)
            }
        }
    }
}