package com.enseirb.myreceipts.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enseirb.myreceipts.network.CategoryService
import com.enseirb.myreceipts.R

class ReceiptActivity : AppCompatActivity(){

    private var categoryService: CategoryService = CategoryService();

    private lateinit var titleView: TextView
    private lateinit var thumbView: ImageView
    private lateinit var instructionsView: TextView
    private lateinit var ingredientsView: RecyclerView
    private lateinit var youtubeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val intent = getIntent()
        val idMeal = intent.getStringExtra("idMeal")

        youtubeButton = findViewById(R.id.youtube_button)
        titleView = findViewById(R.id.meal_name)
        thumbView = findViewById(R.id.meal_thumb)
        instructionsView = findViewById(R.id.instructions_text)
        ingredientsView = findViewById(R.id.ingredients_list)

        categoryService.getReceiptsOfMeal(idMeal!!, titleView, thumbView, ingredientsView, instructionsView, youtubeButton, applicationContext, this);
    }
}