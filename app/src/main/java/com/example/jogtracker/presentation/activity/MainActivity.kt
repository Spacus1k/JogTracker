package com.example.jogtracker.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.jogtracker.R
import com.example.jogtracker.databinding.ActivityMainBinding
import com.example.jogtracker.presentation.fragments.JogHistoryFragment
import com.example.jogtracker.presentation.utils.UIConstants.MIN_NUMBER_OF_FRAGMENTS_IN_BACKSTACK
import com.example.jogtracker.presentation.utils.openFragment
import com.example.jogtracker.presentation.utils.showToast
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val bindingRoot by lazy { binding.root }

    private val navigationItemSelectedListener by lazy {
        NavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> showToast("Clicked Item 1")
                R.id.item2 -> showToast("Clicked Item 2")
                R.id.item3 -> showToast("Clicked Item 3")
            }
            true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingRoot)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener(navigationItemSelectedListener)
        openFragment(
            supportFragmentManager,
            R.id.activity_fragment_container,
            JogHistoryFragment.newInstance(),
            true
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() =
        if (supportFragmentManager.fragments.size == MIN_NUMBER_OF_FRAGMENTS_IN_BACKSTACK) {
            finishAffinity()
        } else {
            super.onBackPressed()
        }
}