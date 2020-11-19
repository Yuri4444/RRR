package com.webanimal.rrr.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.webanimal.rrr.ProductsDetails
import com.webanimal.rrr.R
import com.webanimal.rrr.model.Product

class ProductsAdapter(
    private var products : List<Product>,
    //
    private var onClickProduct: (title: String, photoUrl: String, photoView: View) -> Unit
    //
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val products = products[position]
        Picasso.get().load(products.photoUrl).into(holder.image)
        holder.title.text = products.title

        if (products.isOnSale) {
            holder.isOnSale.setImageResource(R.drawable.plato1r)
        } else {
            holder.isOnSale.setImageResource(R.drawable.travo1r)
        }


        holder.image.setOnClickListener {
            onClickProduct.invoke(products.title, products.photoUrl, holder.image)
//            val intent = Intent(parent.context, ProductsDetails::class.java)
//            intent.putExtra("title", products[holder.adapterPosition].title)
//            intent.putExtra("photo_url", products[holder.adapterPosition].photoUrl)
//            parent.context.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        val holder = ViewHolder(view)
//        view.setOnClickListener {
//            val intent = Intent(parent.context, ProductsDetails::class.java)
//            intent.putExtra("title", products[holder.adapterPosition].title)
//            intent.putExtra("photo_url", products[holder.adapterPosition].photoUrl)
//            parent.context.startActivity(intent)
//        }
        return holder
    }

    override fun getItemCount() = products.size

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.image)
        val title : TextView = itemView.findViewById(R.id.title)
        val isOnSale : ImageView = itemView.findViewById(R.id.saleImageView)
    }
}