package com.example.butikapp.ui.login.login

import androidx.lifecycle.ViewModel
import com.example.butikapp.ui.login.splashscreen.SplashScreenViewModel
import com.example.butikapp.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
}