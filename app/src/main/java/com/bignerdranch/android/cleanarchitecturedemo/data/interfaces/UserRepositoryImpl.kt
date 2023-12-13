package com.bignerdranch.android.cleanarchitecturedemo.data.interfaces



import android.content.Context
import com.bignerdranch.android.cleanarchitecturedemo.domain.interfaces.UserRepository
import com.bignerdranch.android.cleanarchitecturedemo.domain.models.SaveUserNameParam
import com.bignerdranch.android.cleanarchitecturedemo.domain.models.UserName

private const val SHARED_PREFERENCES_NAME = "shared_preferences_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "Default last name"
class UserRepositoryImpl(context: Context) : UserRepository{

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    override fun saveName(param: SaveUserNameParam): Boolean{
        sharedPreferences.edit().putString(KEY_FIRST_NAME, param.name).apply()
        return true
    }
    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserName(firstName = firstName, lastName = lastName)
    }
}