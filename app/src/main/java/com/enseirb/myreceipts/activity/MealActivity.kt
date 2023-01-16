package com.enseirb.myreceipts.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.enseirb.myreceipts.network.CategoryService
import com.enseirb.myreceipts.storage.CategoryStore
import com.enseirb.myreceipts.R

class MealActivity : AppCompatActivity(){
    private var categoryService: CategoryService = CategoryService()

    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryName: TextView
    private lateinit var categoryDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.meals_recycler_view)
        val intent = getIntent()
        var strCategory = intent.getStringExtra("strCategory")
        if (strCategory == null) {
            strCategory = CategoryStore.strCategory
        }
        val strCategoryDescription = if (intent.getStringExtra("strCategoryDescription") != null)
            intent.getStringExtra("strCategoryDescription") else CategoryStore.strCategoryDescription

        categoryName = findViewById(R.id.category_name)
        categoryName.setText(strCategory)
        categoryDescription = findViewById(R.id.category_description)
        categoryDescription.setText(strCategoryDescription)

        categoryService.getDetailsOfCategory(strCategory!!, recyclerView, applicationContext, this);
    }

    fun onSeeMoreClick(view: View) {
        val descriptionView = findViewById<TextView>(R.id.category_description)
        val button: TextView = findViewById(R.id.see_more_text)
        if (descriptionView.maxLines == 2) {
            descriptionView.maxLines = Int.MAX_VALUE
            button.text = "See Less"
        } else {
            descriptionView.maxLines = 2
            button.text = "See More"
        }
    }
}