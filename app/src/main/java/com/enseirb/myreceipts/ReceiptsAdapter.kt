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
    var itemText: TextView = itemView.findViewById(R.id.category_name)
    var itemImage: ImageView = itemView.findViewById(R.id.category_image)

}
class ReceiptsAdapter(val receipts: List<Receipt>, val applicationContext: Context): RecyclerView.Adapter<ReceiptViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceiptViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ReceiptViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReceiptViewHolder, position: Int) {
        holder.itemText.setText(receipts.get(position).strInstructions)
        Picasso.get().load(receipts.get(position).strMealThumb).into(holder.itemImage)
        Log.d("DEBUG", "Got " + receipts.get(position).strIngredient.get(0) + receipts.get(position).strIngredient.get(1) +receipts.get(position).strYoutube + " results");
    }

    override fun getItemCount(): Int {
        return receipts.count()
    }
}