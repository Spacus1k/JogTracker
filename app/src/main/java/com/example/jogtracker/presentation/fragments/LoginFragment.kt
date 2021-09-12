package com.example.jogtracker.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.jogtracker.R
import com.example.jogtracker.databinding.FragmentLoginBinding
import com.example.jogtracker.presentation.LoginViewModel
import com.example.jogtracker.presentation.utils.UIConstants
import com.example.jogtracker.presentation.utils.openFragment
import com.example.jogtracker.presentation.utils.showToast

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val loginViewModel = LoginViewModel()
    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButton()
        initObservers()
    }

    private fun initButton() {
        binding?.loginButton?.setOnClickListener { _ ->
            loginViewModel.loginByUUID(binding?.uuidEditText?.text.toString())
        }
    }

    private fun initObservers() {
        loginViewModel.tokenHolder.observe(viewLifecycleOwner) { tokenHolder ->
            if (tokenHolder != UIConstants.ERROR) {
                activity?.let {
                    openFragment(
                        it.supportFragmentManager,
                        R.id.activity_fragment_container,
                        JogHistoryFragment.newInstance(),
                        false
                    )
                }
            } else {
                context?.let { showToast(it, UIConstants.UUID_INVALID, Toast.LENGTH_SHORT) }
            }
        }
    }
}