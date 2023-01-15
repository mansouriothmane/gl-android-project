package com.enseirb.myreceipts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemText: TextView = itemView.findViewById(R.id.category_name)
    var itemImage: ImageView = itemView.findViewById(R.id.category_image)
}

class MealsAdapter(val meals: List<Meal>, val applicationContext: Context): RecyclerView.Adapter<MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return MealViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.itemText.setText(meals.get(position).strMeal)
        holder.itemView.setOnClickListener{
            val intent = Intent(applicationContext, ReceiptActivity::class.java)
            intent.putExtra("idMeal", meals.get(position).idMeal.toString())
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            applicationContext.startActivity(intent)
        }
        Picasso.get().load(meals.get(position).strMealThumb).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return meals.count()
    }
}