package com.example.voiceactrees.ui.actress.list.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.voiceactrees.data.model.ActreesModel
import com.example.voiceactrees.databinding.ActressItemBinding

class ActressRecyclerViewAdapter(private val clickListener: (ActreesModel) -> Unit) : RecyclerView.Adapter<ActressRecyclerViewHolder>() {

    private val actresses = ArrayList<ActreesModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActressRecyclerViewHolder {
        val binding = ActressItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActressRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return actresses.size
    }

    override fun onBindViewHolder(holder: ActressRecyclerViewHolder, position: Int) {
        val actress = actresses[position]
        holder.bind(actress, clickListener)
    }

    fun setData(actressList: List<ActreesModel>){
        actresses.clear()
        actresses.addAll(actressList)
    }

}