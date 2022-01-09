package com.example.butikapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.butikapp.R
import com.example.butikapp.ui.admin.buyrequest.BuyRequestModel
import com.example.butikapp.ui.admin.panel.AdminPanelModel

class BuyRequestAdapter(
    val listener:BuyRequestClick
) : ListAdapter<BuyRequestModel, BuyRequestAdapter.FragmentHolder>(
    diffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_buy_request,
            parent,
            false
        )
        return FragmentHolder(itemView)
    }

    override fun onBindViewHolder(holder: FragmentHolder, position: Int) {
        with(getItem(position)) {
        holder.productId.text=this.buyRequestItemId
            holder.buyerId.text=this.buyRequestBuyer
        }
    }
    inner class FragmentHolder(iv: View) : RecyclerView.ViewHolder(iv) {
        val productId:TextView=iv.findViewById(R.id.itemBuyRequestid)
        val buyerId:TextView=iv.findViewById(R.id.itemBuyRequestPersonName)
        val accept:ImageView=iv.findViewById(R.id.itemBuyRequestAccepted)
        val reject:ImageView=iv.findViewById(R.id.itemBuyRequestDecline)

        init {
            accept.setOnClickListener{
                listener.buyRequestAccept(getItem(adapterPosition))
            }
            reject.setOnClickListener{
                listener.buyRequestReject(getItem(adapterPosition))
            }
        }
    }
}

private val diffCallback = object : DiffUtil.ItemCallback<BuyRequestModel>() {
    override fun areItemsTheSame(oldItem: BuyRequestModel, newItem: BuyRequestModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: BuyRequestModel,
        newItem: BuyRequestModel
    ): Boolean {
        return oldItem == newItem
    }
}