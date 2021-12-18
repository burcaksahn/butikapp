package com.example.butikapp.ui.admin.panel

import androidx.lifecycle.ViewModel
import com.example.butikapp.utils.ViewModelKey
import dagger.Binds
import dagger.multibindings.IntoMap

abstract class AdminPanelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AdminPanelViewModel::class)
    internal abstract fun AdminPanelViewModel(viewModel: AdminPanelModule): ViewModel
}