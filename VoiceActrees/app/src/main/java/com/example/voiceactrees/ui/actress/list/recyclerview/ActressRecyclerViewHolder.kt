package com.example.voiceactrees.ui.actress.list.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.voiceactrees.data.model.ActreesModel
import com.example.voiceactrees.databinding.ActressItemBinding

class ActressRecyclerViewHolder(private val binding: ActressItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(actress: ActreesModel, clickListener: (ActreesModel) -> Unit){
        binding.nameTextView.text = actress.name
        binding.ageTextView.text = actress.age

        binding.itemCardView.setOnClickListener {
            clickListener(actress)
        }
    }
}