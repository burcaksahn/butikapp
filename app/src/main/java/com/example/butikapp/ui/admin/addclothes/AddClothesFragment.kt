package com.example.butikapp.ui.admin.addclothes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.butikapp.R
import com.example.butikapp.databinding.FragmentAddClothesBinding

class AddClothesFragment : Fragment() {

    private lateinit var binding: FragmentAddClothesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAddClothesBinding.inflate(inflater,container,false)
        return binding.root
    }

}