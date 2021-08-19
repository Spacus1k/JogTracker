package com.example.jogtracker.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jogtracker.databinding.ItemJogBinding
import com.example.jogtracker.domain.Jog

class JogViewHolder private constructor(
    binding: ItemJogBinding,
    private val itemClickListener: JogAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    companion object {
        fun createViewHolder(
            parent: ViewGroup,
            clickListener: JogAdapter.OnItemClickListener
        ): JogViewHolder {

            return JogViewHolder(
                ItemJogBinding.inflate(
                    LayoutInflater
                        .from(parent.context), parent, false
                ),
                clickListener
            )
        }
    }

    private val jogDistance: TextView = binding.jogDistance
    private val dateView: TextView = binding.jogDate

    override fun onClick(v: View?) {
        if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
            itemClickListener.onItemClick(absoluteAdapterPosition)
        }
    }

    fun bind(jog: Jog) {
        jogDistance.text = jog.distance.toString()
        dateView.text = jog.date.toString()
    }
}