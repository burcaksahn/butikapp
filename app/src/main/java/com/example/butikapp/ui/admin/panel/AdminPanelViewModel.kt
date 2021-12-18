package com.example.butikapp.ui.admin.panel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class AdminPanelViewModel @Inject constructor(val auth: FirebaseAuth, val firebaseDatabase: FirebaseDatabase): ViewModel() {
}