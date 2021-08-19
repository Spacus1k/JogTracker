package com.example.jogtracker.presentation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun openFragment(
    fragmentManager: FragmentManager,
    containerViewId: Int,
    fragment: Fragment,
    isAddToBackStack: Boolean = true
) {
    val transaction = fragmentManager
        .beginTransaction()
        .replace(containerViewId, fragment, fragment.tag)

    if (isAddToBackStack) transaction.addToBackStack(fragment.tag)

    transaction.commit()
}