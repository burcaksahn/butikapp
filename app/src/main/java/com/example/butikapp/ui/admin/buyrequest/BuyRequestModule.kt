package com.example.butikapp.ui.admin.buyrequest

import androidx.lifecycle.ViewModel
import com.example.butikapp.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BuyRequestModule {
    @Binds
    @IntoMap
    @ViewModelKey(BuyRequestViewModel::class)
    internal abstract fun BuyRequestViewModule(viewModel: BuyRequestViewModel): ViewModel
}