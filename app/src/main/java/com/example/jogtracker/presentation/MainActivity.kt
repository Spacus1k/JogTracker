package com.example.jogtracker.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jogtracker.R
import com.example.jogtracker.presentation.fragments.MainFragment
import com.example.jogtracker.presentation.utils.openFragment

class MainActivity : AppCompatActivity() {

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
}