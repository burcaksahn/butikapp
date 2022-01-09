package com.example.butikapp.ui.admin.panel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.butikapp.R
import com.example.butikapp.databinding.FragmentAdminPanelBinding
import com.example.butikapp.di.MyApp
import com.example.butikapp.ui.login.login.LoginViewModel
import com.example.butikapp.utils.AdminPanalAdapter
import com.example.butikapp.utils.ViewModelFactory
import javax.inject.Inject

class AdminPanelFragment : Fragment() {

 private lateinit var viewModel: AdminPanelViewModel

  @Inject
  lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding:FragmentAdminPanelBinding
    private lateinit var adapter:AdminPanalAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAdminPanelBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()
        initialVM()
        initialRecycler()
    }
    private fun initialUI(){
        MyApp.appComponent.inject(this)
    }
    private fun initialVM(){
        viewModel= ViewModelProvider(this,viewModelFactory).get(AdminPanelViewModel::class.java)
    }
    private fun initialRecycler(){
        adapter=AdminPanalAdapter()
        binding.adminpanellayoutrecycler.layoutManager=LinearLayoutManager(context)
        binding.adminpanellayoutrecycler.adapter=adapter
    }

}