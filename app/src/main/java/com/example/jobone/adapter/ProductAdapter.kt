package com.example.jobone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jobone.Product
import com.example.jobone.R

class ProductAdapter (private val product:List<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
   inner class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

       val productImages = itemView.findViewById<ImageView>(R.id.productImages)
       val productID = itemView.findViewById<TextView>(R.id.idTxt)
       val productName = itemView.findViewById<TextView>(R.id.nameTxt)
       val productPrice = itemView.findViewById<TextView>(R.id.priceTxt)
       val productDesc = itemView.findViewById<TextView>(R.id.descTxt)

       fun  bind(product: Product){
           productName.text = product.title
           productID.text = product.id.toString()
           productPrice.text = product.price.toString()
           productDesc.text = product.description
           Glide.with(itemView).load(product.images[0])
               .into(productImages)

       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
           val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
           return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
          return product.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(product[position])

    }
}