package com.webanimal.rrr.ui.fragmentsERAS

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.webanimal.rrr.R
import com.webanimal.rrr.model.Product
import com.webanimal.rrr.ui.adapter.ProductsAdapter
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

//class FirstFragment : Fragment() {
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)
//    }
//
//}

class FirstFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_first, container, false)

        doAsync {
            val json = URL("https://run.mocky.io/v3/e8ec28a5-62f6-4ea2-aa07-67395702cf46").readText()

            uiThread {
                Log.d("Main", "json -> $json")
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