package com.example.butikapp.ui.login.login

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class LoginViewModel @Inject constructor(val auth:FirebaseAuth, val firebaseDatabase: FirebaseDatabase): ViewModel() {

    fun auth(email:String, password:String) {


    }
}