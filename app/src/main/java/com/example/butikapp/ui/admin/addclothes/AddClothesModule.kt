package com.example.butikapp.ui.admin.addclothes

import androidx.lifecycle.ViewModel

import com.example.butikapp.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddClothesModule {
    @Binds
    @IntoMap
    @ViewModelKey(AddClothesViewModel::class)
    internal abstract fun AddClothesViewModel(viewModel: AddClothesViewModel): ViewModel
}