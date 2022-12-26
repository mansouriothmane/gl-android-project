package com.enseirb.myreceipts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemText: TextView = itemView.findViewById(R.id.category_name)
    var itemImage: ImageView = itemView.findViewById(R.id.category_image)
}

// move this shit from here
class Category {
    var idCategory: Int? = null
    var strCategory: String? = null
    var strCategoryThumb: String? = null
    var strCategoryDescription: String? = null
}

class CategoriesAdapter(val categories: Array<String>, val images: IntArray): RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.itemText.setText(categories.get(position))
        holder.itemImage.setImageResource(images.get(position))
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}