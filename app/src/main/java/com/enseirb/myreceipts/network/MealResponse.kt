package com.enseirb.myreceipts.network

import com.enseirb.myreceipts.data.Meal

class MealResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    var meals: List<Meal>? = null
}