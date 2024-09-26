package com.example.jobone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobone.adapter.ProductAdapter
import com.example.jobone.viewModel.ProductViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductActivity : AppCompatActivity() {

    private lateinit var  productViewModel:ProductViewModel
    private lateinit var  productAdapter:ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

      productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productAdapter = ProductAdapter(emptyList())

        val refreshBtn:FloatingActionButton = findViewById(R.id.refreshBtn)
        refreshBtn.setOnClickListener {
          startActivity(Intent(this@ProductActivity, ProductActivity::class.java))
            finish()
        }

        val productRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        productRecyclerView.layoutManager = LinearLayoutManager(this)

        productViewModel.products.observe(this){
            productAdapter = ProductAdapter(it)
            productRecyclerView.adapter = productAdapter

        }

    }
}