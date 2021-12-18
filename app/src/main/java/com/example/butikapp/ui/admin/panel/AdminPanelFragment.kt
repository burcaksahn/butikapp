package com.example.butikapp.ui.admin.panel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.butikapp.R
import com.example.butikapp.databinding.FragmentAdminPanelBinding

class AdminPanelFragment : Fragment() {

    private lateinit var binding:FragmentAdminPanelBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAdminPanelBinding.inflate(inflater,container,false)
        return binding.root

    }

}