package com.enseirb.myreceipts.data

import com.google.gson.annotations.SerializedName
import java.util.Date

class Receipt {
    var idMeal: Int? = null
    var strMeal: String? = null
    var strDrinkAlternate: String? = null
    var strCategory: String? = null
    var strArea: String? = null
    var strInstructions: String? = null
    var strMealThumb: String? = null
    var strTags: String? = null
    var strYoutube: String? = null
    var strIngredient: MutableList<String?> = mutableListOf()
    var strMeasure: MutableList<String?> = mutableListOf()
    var strSource: String? = null
    var strImageSource: String? = null
    var strCreativeCommonsConfirmed: String? = null
    var dateModified: Date? = null
}