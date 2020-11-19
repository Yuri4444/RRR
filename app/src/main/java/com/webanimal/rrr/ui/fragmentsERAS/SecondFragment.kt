package com.webanimal.rrr.ui.fragmentsERAS

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.webanimal.rrr.ProductsDetails
import com.webanimal.rrr.R
import com.webanimal.rrr.model.Product
import com.webanimal.rrr.repository.ProductsRepository
import com.webanimal.rrr.ui.adapters.ProductsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

//class SecondFragment : Fragment() {
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false)
//    }
//
//}

class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_second, container, false)

//        doAsync {
//            val json = URL("https://run.mocky.io/v3/f0518056-338b-49a1-9837-11e635151f32").readText()
//
//            uiThread {
//                Log.d("Main", "json -> $json")
//                val products = Gson().fromJson(json, Array<Product>::class.java).toList()
//
//                root.recycler_view1.apply {
//                    layoutManager = LinearLayoutManager(activity)
//                    adapter = ProductsAdapter(products)
////                    adapter.setMethod(products)
//                    root.progressBar.visibility = View.GONE
//                }
//            }
//        }

        return root
    }

    // ++++++
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productsRepository = ProductsRepository().getAllProducts2()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
//                d("products", "success :)")
                recycler_view1.apply {
                    layoutManager = LinearLayoutManager(activity)

                    adapter = ProductsAdapter(it)
                    { extraTitle, extraImageUrl, photoUrl ->
                        val intent = Intent(activity, ProductsDetails::class.java)
                        intent.putExtra("title", extraTitle)
                        intent.putExtra("photo_url", extraImageUrl)
                        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity as AppCompatActivity, photoUrl, "photoToAnimate")
                        startActivity(intent, options.toBundle())

                    }

                }
                progressBar.visibility = View.GONE

            },{
//            d("products", "error :( ${it.message}")
            })


    }
    // ++++++


}