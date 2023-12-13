package com.bignerdranch.android.cleanarchitecturedemo.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userStorage by lazy { data.storage.sharedPrefs.SharedPrefUserStorage(context = context) }
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        data.respository.UserRepositoryImpl(
            userStorage
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        domain.usecase.GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase, saveUserNameUseCase =  saveUserNameUseCase) as T
    }
}