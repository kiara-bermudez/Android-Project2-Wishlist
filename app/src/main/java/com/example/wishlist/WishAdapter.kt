package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Create class and pass in a list of the items you wish to display
class WishAdapter (private val wishes: List<Wish>) : RecyclerView.Adapter<WishAdapter.ViewHolder>()
{
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nameTextView = itemView.findViewById<TextView>(R.id.itemNameTv)
        val priceTextView = itemView.findViewById<TextView>(R.id.itemPriceTv)
        val urlTextView = itemView.findViewById<TextView>(R.id.urlTv)
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: WishAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val wish: Wish = wishes.get(position)
        // Set item views based on your views and data model
        val nameTextView = viewHolder.nameTextView
        nameTextView.setText(wish.item)

        viewHolder.priceTextView.text = wish.price.toString()

        viewHolder.urlTextView.text = wish.url
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return wishes.size
    }
}