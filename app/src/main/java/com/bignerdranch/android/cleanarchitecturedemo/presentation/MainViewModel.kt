package com.bignerdranch.android.cleanarchitecturedemo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.usecase.GetUserNameUseCase
import domain.usecase.SaveUserNameUseCase

class MainViewModel(private val saveUserNameUseCase: SaveUserNameUseCase, private val getUserNameUseCase: GetUserNameUseCase): ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable
    init {
        }
    fun save(text: String){
        val params = domain.models.SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value = "Save result = $result"

    }
    fun load(){
        val userName: domain.models.UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}