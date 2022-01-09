package com.example.butikapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.butikapp.R
import com.example.butikapp.ui.admin.panel.AdminPanelModel

class AdminPanalAdapter(
) : ListAdapter<AdminPanelModel, AdminPanalAdapter.FragmentHolder>(
    diffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_admin_panel,
            parent,
            false
        )
        return FragmentHolder(itemView)
    }

    override fun onBindViewHolder(holder: FragmentHolder, position: Int) {
        with(getItem(position)) {

        }
    }
    inner class FragmentHolder(iv: View) : RecyclerView.ViewHolder(iv) {


    }
}

private val diffCallback = object : DiffUtil.ItemCallback<AdminPanelModel>() {
    override fun areItemsTheSame(oldItem: AdminPanelModel, newItem: AdminPanelModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: AdminPanelModel,
        newItem: AdminPanelModel
    ): Boolean {
        return oldItem == newItem
    }
}