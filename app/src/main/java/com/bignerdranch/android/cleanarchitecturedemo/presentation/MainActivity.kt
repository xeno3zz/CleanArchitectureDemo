package com.bignerdranch.android.cleanarchitecturedemo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.bignerdranch.android.cleanarchitecturedemo.R
import com.bignerdranch.android.cleanarchitecturedemo.data.interfaces.UserRepositoryImpl
import com.bignerdranch.android.cleanarchitecturedemo.domain.models.SaveUserNameParam
import com.bignerdranch.android.cleanarchitecturedemo.domain.models.UserName
import com.bignerdranch.android.cleanarchitecturedemo.domain.usecase.GetUserNameUseCase
import com.bignerdranch.android.cleanarchitecturedemo.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(context = applicationContext) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataTextView = findViewById<TextView>(R.id.dataTV)
        val dataEditView = findViewById<EditText>(R.id.dataET)
        val getBtn = findViewById<Button>(R.id.getBtn)
        val saveBtn = findViewById<Button>(R.id.saveBtn)
        getBtn.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
        saveBtn.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }
    }
}