package com.example.jogtracker.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.jogtracker.R
import com.example.jogtracker.data.network.model.response.Jog
import com.example.jogtracker.databinding.FragmentJogInfoBinding
import com.example.jogtracker.presentation.viewModel.MainViewModel
import com.example.jogtracker.presentation.utils.DateConvertor
import com.example.jogtracker.presentation.utils.openFragment

class JogInfoFragment(private val jog: Jog) :
    Fragment() {

    companion object {
        fun newInstance(jog: Jog) = JogInfoFragment(jog)
    }

    //TODO add inject
    private val viewModel = MainViewModel()
    private var binding: FragmentJogInfoBinding? = null
    private val menuClickListener = Toolbar.OnMenuItemClickListener { item ->
        activity?.let { fragmentActivity ->
            when (item?.itemId) {
                R.id.delete_button -> viewModel.removeJogById(jog.id)
                R.id.edit_button ->
                    openFragment(
                        fragmentActivity.supportFragmentManager,
                        R.id.activity_fragment_container,
                        EditFormFragment.newInstance(jog),
                        true
                    )
            }
        }
        true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJogInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButton()
        setJogInfo()
    }

    private fun initButton() {
        binding?.toolbar?.run {
            setOnClickListener {
                activity?.onBackPressed()
            }
            setOnMenuItemClickListener(menuClickListener)
        }
    }

    private fun setJogInfo() {
        binding?.run {
            jogDistance.text = jog.distance.toString()
            jogDate.text = DateConvertor.toString(jog.date)
            jogTime.text = jog.time.toString()
        }
    }
}