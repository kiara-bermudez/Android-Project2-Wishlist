package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the recyclerview in activity layout
        val rvWishes = findViewById<View>(R.id.recyclerView) as RecyclerView
        // Initialize contacts
        var wishes = ArrayList<Wish>()
        // Create adapter passing in the sample user data
        val adapter = WishAdapter(wishes)

        val itemNameET = findViewById<EditText>(R.id.itemNameEt)
        val itemPriceET = findViewById<EditText>(R.id.itemPriceEt)
        val itemUrlET = findViewById<EditText>(R.id.urlEt)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        submitBtn.setOnClickListener {
            // replace this line with wherever you get new records
            val newWish = Wish(itemNameET.text.toString(), itemPriceET.text.toString().toDouble(), itemUrlET.text.toString())
            // update the existing list
            wishes.add(newWish)
            // Notify the adapter that you have changed list
            adapter.notifyDataSetChanged()
        }

        // Attach the adapter to the recyclerview to populate items
        rvWishes.adapter = adapter
        // Set layout manager to position the items
        rvWishes.layoutManager = LinearLayoutManager(this)
    }
}