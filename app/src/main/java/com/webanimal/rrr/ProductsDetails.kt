package com.webanimal.rrr

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.products_details.*

class ProductsDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products_details)

        val title = intent.getStringExtra("title")
        title_name.text = title

    }
}