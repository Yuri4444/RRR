package com.webanimal.rrr.ui.fragmentsERAS

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.webanimal.rrr.MainActivity
import com.webanimal.rrr.ui.adapter.ProductsAdapter
import com.webanimal.rrr.R
import com.webanimal.rrr.model.Product
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.fragment_records.*
import kotlinx.android.synthetic.main.fragment_records.back_to_first
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)

        doAsync {
            val json = URL("https://run.mocky.io/v3/e8368231-03c0-4a2e-9ff3-01cadd58092e").readText()

            uiThread {
                d("Main", "json -> $json")
                val products = Gson().fromJson(json, Array<Product>::class.java).toList()

                root.recycler_view1.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = ProductsAdapter(products)
                    root.progressBar.visibility = View.GONE
                }
            }
        }

        return root
    }

}