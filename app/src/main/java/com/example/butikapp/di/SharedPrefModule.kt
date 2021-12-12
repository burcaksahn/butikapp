package com.example.butikapp.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPrefModule {
    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application?): SharedPreferences {
        val sharedPreferences: SharedPreferences
        sharedPreferences = application?.applicationContext!!.getSharedPreferences(
            "sharedPrefName",
            Context.MODE_PRIVATE
        )
        return sharedPreferences
    }
}