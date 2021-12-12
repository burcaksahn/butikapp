package com.example.butikapp.di

import androidx.lifecycle.ViewModelProvider
import com.example.butikapp.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class FactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}