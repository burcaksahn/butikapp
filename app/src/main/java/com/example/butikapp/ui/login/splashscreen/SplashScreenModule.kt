package com.example.butikapp.ui.login.splashscreen

import androidx.lifecycle.ViewModel
import com.example.butikapp.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashScreenModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel::class)
    internal abstract fun bindLoginViewModel(viewModel: SplashScreenViewModel): ViewModel
}