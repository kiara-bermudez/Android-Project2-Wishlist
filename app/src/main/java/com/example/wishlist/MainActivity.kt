package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the recyclerview in activity layout
        val rvWishes = findViewById<View>(R.id.recyclerView) as RecyclerView
        // Initialize contacts
        val wishes = listOf<Wish>(
            Wish("Coke", 2.00, "https://www.coca-cola.com/")
        )
        // Create adapter passing in the sample user data
        val adapter = WishAdapter(wishes)
        // Attach the adapter to the recyclerview to populate items
        rvWishes.adapter = adapter
        // Set layout manager to position the items
        rvWishes.layoutManager = LinearLayoutManager(this)
    }
}