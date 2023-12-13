package com.bignerdranch.android.cleanarchitecturedemo.domain.interfaces

import com.bignerdranch.android.cleanarchitecturedemo.domain.models.SaveUserNameParam
import com.bignerdranch.android.cleanarchitecturedemo.domain.models.UserName

interface UserRepository {
    fun saveName(param: SaveUserNameParam): Boolean
    fun getName(): UserName
}