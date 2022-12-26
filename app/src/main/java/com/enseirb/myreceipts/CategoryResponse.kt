package com.enseirb.myreceipts


import com.google.gson.annotations.SerializedName

class CategoryResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    var categories: List<Category>? = null

}