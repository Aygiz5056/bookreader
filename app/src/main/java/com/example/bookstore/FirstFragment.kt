package com.example.bookstore

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookstore.recyclerView.BookAdapter
import com.example.bookstore.recyclerView.BookCallBack
import com.example.bookstore.recyclerView.BookItem
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_one.webView
@RequiresApi(Build.VERSION_CODES.O)
class FirstFragment : Fragment(R.layout.fragment_one), BookCallBack {
    var list = listOf(
        "https://mir-knig.com/read_442514-1",
        "https://mir-knig.com/read_208920-1",
        "https://mir-knig.com/read_209956-1",
        "https://mir-knig.com/read_209777-1"
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var bookList = listOf<BookItem>(
            BookItem(
                R.drawable.kamikadze,
                "Путь камикадзе. Как разработчику программного обеспечения выжить в безнадежном проектеи",

                "Йордон Эдвард"
            ),
            BookItem(
                R.drawable.java, "Основы программирования на Java",
                 "С. Сухов"
            ),
            BookItem(
                R.drawable.ideal, "Идеальный программист. Как стать профессионалом разработки ПО",
                 "Роберт Мартин"
            ),
            BookItem(
                R.drawable.kak_pasti_kotov,
                "Как пасти котов. Наставление для программистов, руководящих другими программистами",

                "Дж.Ханк Рейнвотер"
            )
        )
        recyclerView.adapter = BookAdapter(bookList, this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
    webView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        webView.webViewClient = WebViewClient()
        webView.apply {
            loadUrl("${list.get(position)}")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true

        }

    }
}