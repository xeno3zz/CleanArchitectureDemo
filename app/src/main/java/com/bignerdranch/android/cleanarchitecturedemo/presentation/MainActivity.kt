package com.bignerdranch.android.cleanarchitecturedemo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.cleanarchitecturedemo.R
import data.respository.UserRepositoryImpl
import data.storage.sharedPrefs.SharedPrefUserStorage
import domain.models.SaveUserNameParam
import domain.models.UserName
import domain.usecase.GetUserNameUseCase
import domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataTextView = findViewById<TextView>(R.id.dataTV)
        val dataEditView = findViewById<EditText>(R.id.dataET)
        val getBtn = findViewById<Button>(R.id.getBtn)
        val saveBtn = findViewById<Button>(R.id.saveBtn)
        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)
        vm.resultLive.observe(this, Observer {
            dataTextView.text = it
        })
        getBtn.setOnClickListener {
             vm.load()
        }
        saveBtn.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text)
        }
    }
}