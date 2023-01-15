package com.enseirb.myreceipts.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enseirb.myreceipts.network.CategoryService
import com.enseirb.myreceipts.R

class ReceiptActivity : AppCompatActivity(){

    private var categoryService: CategoryService = CategoryService();
    private lateinit var recyclerView: RecyclerView

    private lateinit var titleView: TextView
    private lateinit var thumbView: ImageView
    private lateinit var descriptionView: TextView
    private lateinit var ingredientsView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val intent = getIntent()
        val idMeal = intent.getStringExtra("idMeal")
        //titleView = findViewById(R.id.mealName)
        //thumbView = findViewById(R.id.mealThumb)
        //descriptionView = findViewById(R.id.mealInstructions)
        //ingredientsView = findViewById(R.id.ingredients_recycler_view)

        recyclerView = findViewById(R.id.receipt_recycler_view)

        categoryService.getReceiptsOfMeal(idMeal!!, recyclerView, applicationContext, this);
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Handle the up caret being clicked
                // Navigate to the parent activity
                navigateUpTo(Intent(this, MealActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}