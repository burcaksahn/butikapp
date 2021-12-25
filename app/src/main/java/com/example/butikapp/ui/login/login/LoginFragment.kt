package com.example.butikapp.ui.login.login

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
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
        initialClickListeners()
    }
    private fun initialUI(){
        MyApp.appComponent.inject(this)
    }
    private fun initialVM(){
        viewModel=ViewModelProvider(this,viewModelFactory).get(LoginViewModel::class.java)
    }

    private fun initialClickListeners(){
        binding.loginButton.setOnClickListener {
            auth()
        }
    }
    private fun auth(){
        if (
            !binding.editTextTextPersonName.text.toString().isNullOrEmpty() &&
            !binding.editTextTextPersonName2.text.toString().isNullOrEmpty()
        ) {
            viewModel.auth(binding.editTextTextPersonName.text.toString(),binding.editTextTextPersonName2.text.toString()).observe(viewLifecycleOwner,
                Observer {
                    Log.d("TAG", "auth: "+ it)
                    if (it){
                        getStatus(binding.editTextTextPersonName.text.toString())

                    }else {
                        showWrongMessage(getString(R.string.login_fragment_authentication_fail_message))
                    }
                })
        } else {
            showWrongMessage(getString(R.string.login_fragment_wrong_empty_message))
        }
    }
    private fun getStatus(email:String){
        viewModel.getStatus(email).observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "getStatus: "+ it)
            if (it.equals("admin")){
                routeViews(R.id.action_loginFragment_to_adminPanelFragment)
            }else if (it.equals("user")){
                routeViews(R.id.action_loginFragment_to_adminPanelFragment)
            } else {
                showWrongMessage(getString(R.string.login_fragment_status_fail_message))
            }
        })
    }

    private fun showWrongMessage(message:String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()

    }
    private fun routeViews(page:Int){
        Navigation.findNavController(binding.root).navigate(page)
    }


}