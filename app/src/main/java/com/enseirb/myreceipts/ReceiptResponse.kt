package com.enseirb.myreceipts;

import com.google.gson.annotations.SerializedName

class ReceiptResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    @SerializedName("meals")
    var receipts: List<Receipt>? = null
}