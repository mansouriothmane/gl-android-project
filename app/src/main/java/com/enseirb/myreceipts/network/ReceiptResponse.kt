package com.enseirb.myreceipts.network;

import com.enseirb.myreceipts.data.Receipt
import com.google.gson.annotations.SerializedName

class ReceiptResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    @SerializedName("meals")
    var receipts: List<Receipt>? = null
}