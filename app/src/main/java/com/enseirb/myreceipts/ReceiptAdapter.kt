package com.enseirb.myreceipts

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ReceiptViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemTextTitle: TextView = itemView.findViewById(R.id.mealName)
    var itemImageThumb: ImageView = itemView.findViewById(R.id.mealThumb)
}

class InstructionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemTextInstructions: TextView = itemView.findViewById(R.id.mealInstructions)
}

class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemTextIngredient: TextView = itemView.findViewById(R.id.ingredientText)
    var itemTextMeasure: TextView = itemView.findViewById(R.id.measureText)
}


class ReceiptAdapter(val receipt: Receipt, val applicationContext: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_receipt, parent, false)
            return ReceiptViewHolder(itemView)
        }
        else if (viewType == 1) {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_ingredient, parent, false)
            return IngredientViewHolder(itemView)
        }
        else {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_instructions, parent, false)
            return InstructionsViewHolder(itemView)
        }
    }

    @Override
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        if (viewType == 0) {
            val receiptViewHolder = holder as ReceiptViewHolder
            receiptViewHolder.itemTextTitle.setText(receipt.strMeal)
            Picasso.get().load(receipt.strMealThumb).into(receiptViewHolder.itemImageThumb)
        }
        else if (viewType == 1) {
            val ingredientViewHolder = holder as IngredientViewHolder
            ingredientViewHolder.itemTextIngredient.setText(receipt.strIngredient.get(position-1))
            ingredientViewHolder.itemTextMeasure.setText(receipt.strMeasure.get(position-1))
        }
        else {
            val instructionsViewHolder = holder as InstructionsViewHolder
            instructionsViewHolder.itemTextInstructions.setText(receipt.strInstructions)
        }
    }

    @Override
    override fun getItemViewType(position: Int): Int {
        return if (position == 0)
            0;
        else if (position < getItemCount() - 1)
            1;
        else 2;
    }

    @Override
    override fun getItemCount(): Int {
        return receipt.strIngredient.count() + 2
    }
}