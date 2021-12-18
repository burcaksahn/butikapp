package com.example.butikapp.ui.admin.buyrequest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.butikapp.R
import com.example.butikapp.databinding.FragmentBuyRequestBinding

class BuyRequestFragment : Fragment() {

    private lateinit var binding:FragmentBuyRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentBuyRequestBinding.inflate(inflater,container,false)
        return binding.root
    }


}