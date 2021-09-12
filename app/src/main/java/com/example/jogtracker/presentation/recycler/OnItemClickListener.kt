package com.example.jogtracker.presentation.recycler

import com.example.jogtracker.data.network.model.response.Jog

interface OnItemClickListener {
    fun onItemClick(clickedItem: Jog)
}