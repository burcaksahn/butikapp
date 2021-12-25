package com.example.butikapp.ui.login.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class LoginViewModel @Inject constructor(val auth:FirebaseAuth, val firebaseDatabase: FirebaseDatabase): ViewModel() {

    fun auth(email:String, password:String): MutableLiveData<Boolean> {
        val isSuccess= MutableLiveData<Boolean>()
        if(!email.isNullOrEmpty() && !password.isNullOrEmpty()){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
            isSuccess.value=it.isSuccessful
        }
        } else {
            isSuccess.value=false
        }
    return isSuccess
    }
    fun getStatus(email: String): MutableLiveData<String> {
        val personStatus=MutableLiveData<String>()
        var db=firebaseDatabase.getReference("users")
        db.get().addOnSuccessListener {
            Log.d("TAG", "getStatus1: "+it)
            for (child in it.children){
                Log.d("TAG", "getStatus2: "+child.child("userEmail").getValue().toString())
                if(child.child("userEmail").getValue().toString().equals(email)) {
                personStatus.value=child.child("status").getValue().toString()
                }
            }
        }.addOnFailureListener{
            personStatus.value=it.message
        }
    return personStatus
    }

}