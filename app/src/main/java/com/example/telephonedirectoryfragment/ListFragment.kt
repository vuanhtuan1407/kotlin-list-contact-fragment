package com.example.telephonedirectoryfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toolbar
import androidx.fragment.app.Fragment

class ListFragment: Fragment() {
    lateinit var listView: ListView
    lateinit var items: ArrayList<Information>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.list_view)

        items = arrayListOf()
        items.add(Information("01", "Vu Anh Tuan", "0567891234", "tuan1407@gmail.com"))
        items.add(Information("02", "Tran Thu Huyen", "0123456789", "huyen2404@gmail.com"))
        items.add(Information("03", "Pham Phuong Nga", "0987654321", "pinatsu225@gmail.com"))
        items.add(Information("04", "Tran Duc Canh", "0432198765", "canh2701@gmail.com"))
        for(it in 5..16) {
            items.add(Information("0$it", "Hello", "0987654321", "pinatsu225@gmail.com"))
        }

        listView.adapter = ListViewAdapter(requireContext(), items)

        listView.setOnItemClickListener { parent, view, position, id ->
            val item = items[position]
            if (activity is ItemClickListener)
                (activity as ItemClickListener).ItemClicked(item)
        }
    }

    fun AddItem(item: Information){
        var id = items.size
        item.id = "0$id"
        items.add(item)
    }
}
