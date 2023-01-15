package com.enseirb.myreceipts.network

import com.enseirb.myreceipts.data.Category

class CategoryResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    var categories: List<Category>? = null

}