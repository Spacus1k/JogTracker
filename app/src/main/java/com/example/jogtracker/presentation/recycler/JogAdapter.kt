package com.example.jogtracker.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jogtracker.data.network.model.response.Jog

class JogAdapter(
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<JogViewHolder>() {

    private var list: List<Jog> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogViewHolder =
        JogViewHolder.createViewHolder(parent, itemClickListener)

    override fun onBindViewHolder(holder: JogViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun updateData(jogsList: List<Jog>) {
        list = jogsList
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Jog {
        return list[position]
    }
}