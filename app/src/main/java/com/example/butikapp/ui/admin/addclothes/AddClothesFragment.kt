package com.example.butikapp.ui.admin.addclothes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        clickListener()
    }
    private fun initialUI(){
        MyApp.appComponent.inject(this)
    }
    private fun initialVM(){
        viewModel= ViewModelProvider(this,viewModelFactory).get(AddClothesViewModel::class.java)

    }
    private fun clickListener(){
        binding.imageView2.setOnClickListener{

        }

        binding.addClothesFragmentButton.setOnClickListener {
            addClothe()

        }
    }
    private fun addClothe(){
        if(!binding.addClothesFragmentClothesNames.text.toString().isNullOrEmpty() &&
                !binding.addClothesFragmentClothesCategory.text.toString().isNullOrEmpty()&&
                    !binding.addClothesFragmentClothesSize.text.toString().isNullOrEmpty()&&
                    !binding.addClothesFragmentClothesColor.text.toString().isNullOrEmpty()&&
                    !binding.addClothesFragmentClothesPrice.text.toString().isNullOrEmpty()){
        viewModel.addClothe(model = AddClothesModel(binding.addClothesFragmentClothesNames.text.toString(),
            binding.addClothesFragmentClothesColor.text.toString(),
            binding.addClothesFragmentClothesCategory.text.toString(),
            binding.addClothesFragmentClothesPrice.text.toString(),
            binding.addClothesFragmentClothesSize.text.toString(),
            ""))
        }else{
            showWrongMessage(message =getString(R.string.add_card_fragment_emtpty_message))
        }


    }
    private fun showWrongMessage(message:String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }
}