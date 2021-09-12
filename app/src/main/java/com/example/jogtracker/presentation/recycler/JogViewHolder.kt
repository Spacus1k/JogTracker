package com.example.jogtracker.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jogtracker.data.network.model.response.Jog
import com.example.jogtracker.databinding.ItemJogBinding
import com.example.jogtracker.presentation.utils.DateConvertor
import com.example.jogtracker.presentation.utils.UIConstants

class JogViewHolder private constructor(
    binding: ItemJogBinding,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun createViewHolder(
            parent: ViewGroup,
            clickListener: OnItemClickListener
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

    fun bind(jog: Jog) {
        jogDistance.text = (jog.distance.toString() +" "+UIConstants.KILOMETER)
        dateView.text = DateConvertor.toString(jog.date)

        itemView.setOnClickListener {
            itemClickListener.onItemClick(jog)
        }
    }
}