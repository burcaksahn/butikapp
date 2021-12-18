package com.example.butikapp.ui.admin.addclothes

import androidx.lifecycle.ViewModel

import com.example.butikapp.utils.ViewModelKey
import dagger.Binds
import dagger.multibindings.IntoMap

abstract class AddClothesModule {
    @Binds
    @IntoMap
    @ViewModelKey(AddClothesViewModel::class)
    internal abstract fun AddClothesViewModel(viewModel: AddClothesViewModel): ViewModel
}