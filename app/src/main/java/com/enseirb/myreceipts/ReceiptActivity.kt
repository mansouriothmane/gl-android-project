package com.enseirb.myreceipts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class ReceiptActivity : AppCompatActivity(){
    private var categoryService: CategoryService = CategoryService();


    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)
        recyclerView = findViewById(R.id.meal_recycler_view)
        val intent = getIntent()
        val idMeal = intent.getStringExtra("idMeal")

        categoryService.getReceiptsOfMeal(idMeal!!,recyclerView,applicationContext, this);
    }
}