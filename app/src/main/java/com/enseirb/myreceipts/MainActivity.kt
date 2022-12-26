package com.enseirb.myreceipts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var categories: Array<String>

    private var images = intArrayOf(
        R.drawable.beef, R.drawable.beef, R.drawable.beef, R.drawable.beef,
        R.drawable.beef, R.drawable.beef, R.drawable.beef, R.drawable.beef,
        R.drawable.beef, R.drawable.beef, R.drawable.beef, R.drawable.beef,
        R.drawable.beef, R.drawable.beef
    );

    private lateinit var recyclerView: RecyclerView

    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        categories = resources.getStringArray(R.array.categories)

        categoriesAdapter = CategoriesAdapter(categories, images)
        recyclerView.adapter = categoriesAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
    }
}