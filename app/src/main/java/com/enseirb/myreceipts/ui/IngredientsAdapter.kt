package com.enseirb.myreceipts.ui

import com.enseirb.myreceipts.R
import com.enseirb.myreceipts.data.Receipt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IngredientItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemTextIngredient: TextView = itemView.findViewById(R.id.ingredient_name)
    var itemTextMeasure: TextView = itemView.findViewById(R.id.ingredient_measure)
}

class IngredientsAdapter(val receipt: Receipt, val applicationContext: Context): RecyclerView.Adapter<IngredientItemViewHolder>() {

    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_ingredient, parent, false)
        return IngredientItemViewHolder(itemView)
    }

    @Override
    override fun onBindViewHolder(holder: IngredientItemViewHolder, position: Int) {
        holder.itemTextIngredient.setText(receipt.strIngredient.get(position))
        holder.itemTextMeasure.setText(receipt.strMeasure.get(position))
    }

    @Override
    override fun getItemCount(): Int {
        return receipt.strIngredient.count()
    }
}