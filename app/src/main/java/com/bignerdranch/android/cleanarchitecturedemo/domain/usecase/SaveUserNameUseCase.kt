package com.bignerdranch.android.cleanarchitecturedemo.domain.usecase

import com.bignerdranch.android.cleanarchitecturedemo.domain.interfaces.UserRepository
import com.bignerdranch.android.cleanarchitecturedemo.domain.models.SaveUserNameParam

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean{
        val result = userRepository.saveName(param = param)
        return result
    }
}