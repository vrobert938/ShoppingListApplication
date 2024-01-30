package com.example.shoppinglistapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryRVAdapter(
    var list: List<GroceryItems>,
    private val groceryItemClickInterface: GroceryItemClickInterface
)
    : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>() {


    inner class GroceryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameTV: TextView = itemView.findViewById<TextView>(R.id.idtvitemname)
        val quantityTV = itemView.findViewById<TextView>(R.id.idtvquantity)
        val rateTV = itemView.findViewById<TextView>(R.id.idtvrate)
        val totalTV = itemView.findViewById<TextView>(R.id.idtvtotalamount)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idivdelete)
    }




    interface GroceryItemClickInterface{
        fun onItemClick(groceryItems: GroceryItems)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item,parent,false)
        return GroceryViewHolder(view)
    }


    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val currentItem = list[position]

        holder.nameTV.text = currentItem.itemName
        holder.quantityTV.text = currentItem.itemQuantity.toString()
        holder.rateTV.text = "Ft: " + currentItem.itemPrice.toString()

        val itemTotal: Double = currentItem.itemQuantity * currentItem.itemPrice
        holder.totalTV.text = "Ft: " + itemTotal.toString()

        holder.deleteIV.setOnClickListener {
            groceryItemClickInterface.onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}