package com.example.butikapp.ui.admin.panel

import androidx.lifecycle.ViewModel
import com.example.butikapp.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AdminPanelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AdminPanelViewModel::class)
    internal abstract fun bindsAdminPanelViewModel(viewModel: AdminPanelViewModel): ViewModel
}