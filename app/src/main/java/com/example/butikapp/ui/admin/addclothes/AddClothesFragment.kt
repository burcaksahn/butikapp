package com.example.butikapp.ui.admin.addclothes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.butikapp.R
import com.example.butikapp.databinding.FragmentAddClothesBinding
import com.example.butikapp.di.MyApp
import com.example.butikapp.ui.login.login.LoginViewModel
import com.example.butikapp.utils.ViewModelFactory
import javax.inject.Inject

class AddClothesFragment : Fragment() {


    private lateinit var viewModel: AddClothesViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: FragmentAddClothesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAddClothesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialUI()
        initialVM()
    }
    private fun initialUI(){
        MyApp.appComponent.inject(this)
    }
    private fun initialVM(){
        viewModel= ViewModelProvider(this,viewModelFactory).get(AddClothesViewModel::class.java)
    }

}