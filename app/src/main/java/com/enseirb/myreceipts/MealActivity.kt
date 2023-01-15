package com.enseirb.myreceipts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.util.Log

class MealActivity : AppCompatActivity(){
    private var categoryService: CategoryService = CategoryService()

    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryName: TextView
    private lateinit var categoryDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.meal_recycler_view)
        val intent = getIntent()
        var strCategory = intent.getStringExtra("strCategory")
        if (strCategory == null) {
            strCategory = CategoryStore.strCategory
        }
        val strCategoryDescription = if (intent.getStringExtra("strCategoryDescription") != null)
            intent.getStringExtra("strCategoryDescription") else CategoryStore.strCategoryDescription

        Log.d("ONCREATE", strCategory!!)

        categoryName = findViewById(R.id.category_name)
        categoryName.setText(strCategory)

        categoryDescription = findViewById(R.id.category_description)
        categoryDescription.setText(strCategoryDescription)

        categoryService.getDetailsOfCategory(strCategory!!, recyclerView, applicationContext, this);
    }
}