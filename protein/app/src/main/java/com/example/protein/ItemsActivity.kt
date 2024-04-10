package com.example.protein

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "whey1", "Amix Gold Whey Protein Isolate", "iso whey", "carbs 1 fat 0 protein 88", 2493.00F))
        items.add(Item(1, "whey2", "Amix Nutrition Whey Pro Fusion", "whey", "carbs 2 fat 0 protein 75", 640.00F))
        items.add(Item(1, "crea1", "Amix Creatine Monohydrate Creapure", "creatine", "1000 mg creatine", 790.00F))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}