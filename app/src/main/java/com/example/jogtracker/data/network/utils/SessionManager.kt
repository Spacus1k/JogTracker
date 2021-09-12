package com.example.jogtracker.data.network.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.jogtracker.R

class SessionManager(context: Context) {
    companion object {
        const val USER_TOKEN = "user_token"
    }

    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
        Log.e("SessionManager","token saved")
    }

    fun fetchAuthToken(): String? {
        Log.e("SessionManager","token get")
        prefs.getString(USER_TOKEN, null)?.let { Log.e("SessionManager", it) }
        return prefs.getString(USER_TOKEN, null)
    }
}