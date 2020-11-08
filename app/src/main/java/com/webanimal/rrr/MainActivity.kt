package com.webanimal.rrr

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.webanimal.rrr.model.Product
import kotlinx.android.synthetic.main.content_main.*

//https://i.pinimg.com/originals/6d/9c/fe/6d9cfe40d090a18aa34f1676baf6c37a.jpg
//https://sand-box.com.ua/image/cache/data/trafaret/trafaret-a6-dinozavr-4730-500x500_0.jpg
//https://i.pinimg.com/originals/6f/9e/ac/6f9eac641b6214ff64d62050c65ae8b5.jpg
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val products = arrayListOf<Product>()

        for(i in 0..100) {
            products.add(Product("Organic #$i", "https://chuoihaenie.files.wordpress.com/2013/07/tumblr_mdazminh021qi98uvo1_500.jpg", "AAAAAA"))
        }

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ProductsAdapter(products)
        }

    }
}