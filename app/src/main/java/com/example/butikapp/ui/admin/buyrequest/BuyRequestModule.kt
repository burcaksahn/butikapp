package com.example.butikapp.ui.admin.buyrequest

import androidx.lifecycle.ViewModel
import com.example.butikapp.utils.ViewModelKey
import dagger.Binds
import dagger.multibindings.IntoMap

abstract class BuyRequestModule {
    @Binds
    @IntoMap
    @ViewModelKey(BuyRequestViewModel::class)
    internal abstract fun BuyRequestViewModule(viewModel: BuyRequestViewModel): ViewModel
}