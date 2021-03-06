package com.example.butikapp.di

import com.example.butikapp.MainActivity
import com.example.butikapp.ui.admin.addclothes.AddClothesFragment
import com.example.butikapp.ui.admin.addclothes.AddClothesModule
import com.example.butikapp.ui.admin.buyrequest.BuyRequestFragment
import com.example.butikapp.ui.admin.buyrequest.BuyRequestModule
import com.example.butikapp.ui.admin.panel.AdminPanelFragment
import com.example.butikapp.ui.admin.panel.AdminPanelModule
import com.example.butikapp.ui.login.login.LoginFragment
import com.example.butikapp.ui.login.login.LoginModule
import com.example.butikapp.ui.login.splashscreen.SplashScreenFragment
import com.example.butikapp.ui.login.splashscreen.SplashScreenModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        FactoryModule::class,
        FireBaseModule::class,
        SharedPrefModule::class,
        LoginModule::class,
        SplashScreenModule::class,
        AddClothesModule::class,
        BuyRequestModule::class,
        AdminPanelModule::class
    ]
)
interface AppComponent {
    fun inject(splashScreen: SplashScreenFragment)
    fun inject(loginFragment: LoginFragment)
    fun inject(mainActivity: MainActivity)
    fun inject(addClothesFragment: AddClothesFragment)
    fun inject(buyRequestFragment: BuyRequestFragment)
 fun inject(adminPanelFragment: AdminPanelFragment)
}