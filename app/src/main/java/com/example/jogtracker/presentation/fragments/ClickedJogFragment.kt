package com.example.jogtracker.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.jogtracker.R
import com.example.jogtracker.databinding.FragmentClickedJogBinding
import com.example.jogtracker.data.network.model.Jog
import com.example.jogtracker.presentation.MainViewModel
import com.example.jogtracker.presentation.utils.openFragment

class ClickedJogFragment(private val jog: Jog) :
    Fragment(),
    Toolbar.OnMenuItemClickListener {

    companion object {
        fun newInstance(jog: Jog) = ClickedJogFragment(jog)
    }

    //TODO add inject
    private val viewModel = MainViewModel()
    private var binding: FragmentClickedJogBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClickedJogBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButton()
    }
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.delete_button -> activity?.let { viewModel.removeJogById(jog.id) }
            R.id.edit_button -> activity?.let {
                openFragment(
                    it.supportFragmentManager,
                    R.id.activity_fragment_container,
                    EditFormFragment.newInstance(),
                    true
                )
            }
        }
        return true
    }

    private fun initButton() {
        binding?.toolbar?.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}