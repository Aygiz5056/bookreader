package com.example.bookstore.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import kotlinx.android.synthetic.main.book_item.view.*

class BookAdapter (private val bookList: List<BookItem>, private val callBack: BookCallBack) :
    RecyclerView.Adapter<BookAdapter
    .BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.book_item,
            parent, false
        )
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentItem = bookList[position]

        holder.imageView.setImageResource(currentItem.bookPicture)
        holder.bookName.text = currentItem.name
        holder.author.text = currentItem.author
//        holder.genre.text = currentItem.genre

        holder.itemView.setOnClickListener {
            callBack.onClick(position)
        }
    }

    override fun getItemCount() = bookList.size
    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.imageView
        val bookName = itemView.bookName
        val author = itemView.author
//        val genre = itemView.genre
    }
}
