package com.bignerdranch.android.cleanarchitecturedemo.domain.usecase

import com.bignerdranch.android.cleanarchitecturedemo.domain.interfaces.UserRepository
import com.bignerdranch.android.cleanarchitecturedemo.domain.models.UserName

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName{
        return userRepository.getName()
    }
}