package com.example.voiceactrees.ui.actress.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.voiceactrees.ActressApplication
import com.example.voiceactrees.data.model.ActreesModel
import com.example.voiceactrees.repositories.ActressRepository

class ActressViewModel(private val repository: ActressRepository):ViewModel() {

    var name = MutableLiveData("")
    var age = MutableLiveData("")
    var status = MutableLiveData("")

    fun getActresses() = repository.getActresses()

    fun addActresses(actress: ActreesModel) = repository.addActresses(actress)

    fun createActress(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val actress = ActreesModel(
            name.value!!,
            age.value!!
        )

        addActresses(actress)
        clearData()

        status.value = ACTRESS_CREATED
    }

    private fun validateData():Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            age.value.isNullOrEmpty() -> return false
        }

        return true
    }

    fun clearData(){
        name.value = ""
        age.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun setSelectedActress(actress: ActreesModel){
        name.value = actress.name
        age.value = actress.age
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ActressApplication
                ActressViewModel(app.actressRepository)
            }
        }

        const val ACTRESS_CREATED = "Actress created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

}