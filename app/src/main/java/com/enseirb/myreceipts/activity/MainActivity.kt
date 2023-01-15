package com.enseirb.myreceipts.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.enseirb.myreceipts.network.CategoryService
import com.enseirb.myreceipts.R

class MainActivity : AppCompatActivity() {

    private var categoryService: CategoryService = CategoryService();

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)

        categoryService.getCategories(recyclerView,applicationContext, this);
    }
}