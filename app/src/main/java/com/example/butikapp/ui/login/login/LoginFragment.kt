package com.example.butikapp.ui.login.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.butikapp.R
import com.example.butikapp.databinding.FragmentLoginBinding
import com.example.butikapp.di.MyApp
import com.example.butikapp.utils.ViewModelFactory
import javax.inject.Inject

class LoginFragment : Fragment() {

    private lateinit var viewModel:LoginViewModel

    @Inject
    lateinit var viewModelFactory:ViewModelFactory
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater,container,false)
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
        viewModel=ViewModelProvider(this,viewModelFactory).get(LoginViewModel::class.java)
    }
    private fun auth(){
        viewModel.auth("","")
    }

    private fun showWrongMessage(message:String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()

    }
    private fun routeViews(page:Int){
        Navigation.findNavController(binding.root).navigate(page)
    }


}