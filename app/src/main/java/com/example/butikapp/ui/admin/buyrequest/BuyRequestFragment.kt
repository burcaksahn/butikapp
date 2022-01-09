package com.example.butikapp.ui.admin.buyrequest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.butikapp.R
import com.example.butikapp.databinding.FragmentBuyRequestBinding
import com.example.butikapp.di.MyApp
import com.example.butikapp.ui.login.login.LoginViewModel
import com.example.butikapp.utils.AdminPanalAdapter
import com.example.butikapp.utils.BuyRequestAdapter
import com.example.butikapp.utils.BuyRequestClick
import com.example.butikapp.utils.ViewModelFactory
import javax.inject.Inject

class BuyRequestFragment : Fragment(), BuyRequestClick {

    private lateinit var viewModel: BuyRequestViewModel
    private lateinit var adapter: BuyRequestAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding:FragmentBuyRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentBuyRequestBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()
        initialVM()
        initialRecyclerView()
        getItems()
    }
    private fun initialUI(){
        MyApp.appComponent.inject(this)
    }
    private fun initialVM(){
        viewModel= ViewModelProvider(this,viewModelFactory).get(BuyRequestViewModel::class.java)
    }
    private fun initialRecyclerView(){
        adapter= BuyRequestAdapter(this)
        binding.buyRequestRecycler.layoutManager= LinearLayoutManager(context)
        binding.buyRequestRecycler.adapter=adapter

    }
    private fun getItems(){
        viewModel.getRequestItems().observe(viewLifecycleOwner, Observer {
        adapter.submitList(it)
        })

    }

    override fun buyRequestAccept(model: BuyRequestModel) {
        viewModel.accept(model)
        // viewModel.reject(model)
    }

    override fun buyRequestReject(model: BuyRequestModel) {
      viewModel.reject(model)
    }

}