package com.example.jogtracker.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jogtracker.databinding.FragmentEditFormBinding
import com.example.jogtracker.domain.Jog
import com.example.jogtracker.presentation.MainViewModel

class EditFormFragment(var jog: Jog? = null) : Fragment() {

    companion object {
        fun newInstance(jog: Jog? = null) = EditFormFragment(jog)
    }

    //TODO add injection
    private val viewModel = MainViewModel()
    private var binding: FragmentEditFormBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditFormBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initEditText()
        initButtons()
    }

    private fun initButtons() {
        binding?.let {
            it.saveButton.setOnClickListener {
                viewModel.updateJog()
            }
            it.toolbar.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun initEditText() {
        jog?.let { jog ->
            binding?.run {
                etClickedJogDistance.setText(jog.distance)
                etClickedItemTime.setText(jog.time.toString())
                etClickedItemDate.setText(jog.date.toString())
            }
        }
    }
}

