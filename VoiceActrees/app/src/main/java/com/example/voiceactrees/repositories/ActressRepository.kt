package com.example.voiceactrees.repositories

import com.example.voiceactrees.data.model.ActreesModel

class ActressRepository(private val actresses: MutableList<ActreesModel>) {

    fun getActresses() = actresses

    fun addActresses(actress:ActreesModel) = actresses.add(0,actress)
}