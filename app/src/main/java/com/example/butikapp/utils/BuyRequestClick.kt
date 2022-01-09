package com.example.butikapp.utils

import com.example.butikapp.ui.admin.buyrequest.BuyRequestModel

interface BuyRequestClick {

    fun buyRequestAccept(model: BuyRequestModel)

    fun buyRequestReject(model:BuyRequestModel)

}


