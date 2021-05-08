package com.example.exo2serie4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class BookAdapter(val books: Array<String>, val itemClickListener: View.OnClickListener)
    : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(book: String, position: Int, itemClickListener: View.OnClickListener) {
            val cardView = itemView.findViewById(R.id.card_view) as CardView
            val iconImageView = cardView.findViewById(R.id.icon) as ImageView
            val nameTextView = cardView.findViewById(R.id.name) as TextView

            iconImageView.setImageResource(R.drawable.book)
            nameTextView.text = book
            cardView.tag = position
            cardView.setOnClickListener(itemClickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = books[position]
        holder.bindItem(country, position, itemClickListener)
    }

    override fun getItemCount(): Int {
        return books.size
    }

}