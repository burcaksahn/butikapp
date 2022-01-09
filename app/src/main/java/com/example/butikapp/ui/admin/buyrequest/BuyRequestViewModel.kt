package com.example.butikapp.ui.admin.buyrequest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class BuyRequestViewModel @Inject constructor(val auth: FirebaseAuth, val firebaseDatabase: FirebaseDatabase): ViewModel() {

    fun getRequestItems():MutableLiveData<List<BuyRequestModel>>{
        val list=MutableLiveData<List<BuyRequestModel>>()
        val tempList= arrayListOf<BuyRequestModel>()
        val dB=firebaseDatabase.getReference("buyRequest")
        dB.get().addOnSuccessListener {
            for (child in it.children){
                tempList.add(BuyRequestModel(child.child("productId").getValue().toString(),child.child("userEmail").getValue().toString()))

            }
            list.value=tempList
        }
    return list
    }
    fun accept(model: BuyRequestModel){

    }

    fun reject(model: BuyRequestModel){

    }
}