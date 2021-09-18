package com.example.jogtracker.presentation.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jogtracker.data.network.model.response.Jog
import com.example.jogtracker.databinding.FragmentEditFormBinding
import com.example.jogtracker.presentation.viewModel.MainViewModel
import com.example.jogtracker.presentation.utils.DateConvertor

class EditFormFragment(var jog: Jog? = null) : Fragment() {

    companion object {
        fun newInstance(jog: Jog? = null) = EditFormFragment(jog)
    }

    private val viewModel = MainViewModel()
    private var binding: FragmentEditFormBinding? = null
    private var datePickerDialog: DatePickerDialog? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditFormBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInfo()
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
            it.editTextDate.setOnClickListener{
                datePickerDialog?.show()
            }
        }
    }

    private fun setInfo() {
        jog?.let { jog ->
            binding?.run {
                editTextDistance.setText(jog.distance.toString())
                editTextTime.setText(jog.time.toString())
                editTextDate.setText(DateConvertor.toString(jog.date))
            }
        }
    }
}

