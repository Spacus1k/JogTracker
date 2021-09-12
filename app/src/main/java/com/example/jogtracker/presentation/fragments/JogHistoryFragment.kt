package com.example.jogtracker.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jogtracker.R
import com.example.jogtracker.data.network.model.response.Jog
import com.example.jogtracker.databinding.FragmentJogHistoryBinding
import com.example.jogtracker.presentation.MainViewModel
import com.example.jogtracker.presentation.recycler.JogAdapter
import com.example.jogtracker.presentation.recycler.OnItemClickListener
import com.example.jogtracker.presentation.utils.openFragment

class JogHistoryFragment : Fragment() {

    companion object {
        fun newInstance() = JogHistoryFragment()
    }

    //TODO add inject
    private val viewModel = MainViewModel()
    private var binding: FragmentJogHistoryBinding? = null
    private val itemClickListener = object : OnItemClickListener {
        override fun onItemClick(clickedItem: Jog) {
            openJogInfoFragment(JogInfoFragment.newInstance(clickedItem))
        }
    }
    private val adapter = JogAdapter(itemClickListener)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJogHistoryBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
        initObservers()
        initRecyclerView()
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

    private fun initRecyclerView() {
        binding?.jogs?.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = this@JogHistoryFragment.adapter
        }
    }

    private fun openJogInfoFragment(fragment: JogInfoFragment) {
        activity?.let {
            openFragment(
                it.supportFragmentManager,
                R.id.activity_fragment_container,
                fragment
            )
        }
    }
}