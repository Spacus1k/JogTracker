package com.example.jogtracker.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jogtracker.R
import com.example.jogtracker.databinding.FragmentMainBinding
import com.example.jogtracker.presentation.MainViewModel
import com.example.jogtracker.presentation.recycler.JogAdapter
import com.example.jogtracker.presentation.utils.openFragment

class MainFragment : Fragment(), JogAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    //TODO add inject
    private val viewModel = MainViewModel()
    private val adapter = JogAdapter(this)
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
        initObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onItemClick(position: Int) {
        val clickedJog = adapter.getItem(position)
        activity?.let {
            openFragment(
                it.supportFragmentManager, R.id.activity_fragment_container,
                ClickedJogFragment.newInstance(clickedJog),
                true
            )
        }
    }

    private fun initObservers() {
        viewModel.jogs.observe(viewLifecycleOwner) { jogs ->
            adapter.updateData(jogs)
        }
    }

    private fun initButtons() {
        binding?.addButton?.setOnClickListener {
            activity?.let {
                openFragment(
                    it.supportFragmentManager,
                    R.id.activity_fragment_container,
                    EditFormFragment.newInstance(),
                    true
                )
            }
        }
    }
}