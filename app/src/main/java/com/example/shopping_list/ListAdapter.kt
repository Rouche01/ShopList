package com.example.shopping_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.shopping_list.view.*

class ListAdapter(private val shoppingList: ArrayList<Lists>, private val callback: ListenerCallback) :RecyclerView.Adapter<ListAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ItemHolder {
        return ItemHolder(LayoutInflater.from(parent?.context).inflate(R.layout.shopping_list, parent, false))
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ItemHolder, position: Int) {
        val item = shoppingList[position]
        holder.apply {
            bindLists(item)
            itemView.setOnClickListener {
                callback.onClick(item)
            }
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindLists (lists : Lists) {
            itemView.shoppingItem.text = lists.items
            itemView.itemQuantity.text = lists.quantity
        }
    }
}