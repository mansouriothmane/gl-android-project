package com.enseirb.myreceipts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemText: TextView = itemView.findViewById(R.id.category_name)
    var itemImage: ImageView = itemView.findViewById(R.id.category_image)
}

class CategoriesAdapter(val categories: List<Category>): RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.itemText.setText(categories.get(position).strCategory)
        Picasso.get().load(categories.get(position).strCategoryThumb).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}