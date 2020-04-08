package com.example.shopping_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListenerCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trialLists = ArrayList<Lists>()

        trialLists.add(Lists("Groceries", "10kg"))
        trialLists.add(Lists("Hand Sanitizers", "5 bottles"))
        trialLists.add(Lists("Milk", "2 gallons"))
        trialLists.add(Lists("Vegetable Oil", "4 litres"))
        trialLists.add(Lists("Chicken", "1 kg"))

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val adapter = ListAdapter(trialLists, this@MainActivity)
        recyclerView.adapter = adapter

    }

    private fun listItemClicked(lists: Lists) {
        Toast.makeText(this, "Clicked: ${lists.items}", Toast.LENGTH_LONG)
    }

    override fun onClick(list: Lists) {
        Toast.makeText(this, list.items.toString(), Toast.LENGTH_SHORT).show()
    }
}
