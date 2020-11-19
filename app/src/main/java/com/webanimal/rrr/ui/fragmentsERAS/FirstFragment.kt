package com.webanimal.rrr.ui.fragmentsERAS

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.google.gson.Gson
import com.webanimal.rrr.ProductsDetails
import com.webanimal.rrr.R
import com.webanimal.rrr.database.AppDatabase
import com.webanimal.rrr.database.ProductFromDatabase
import com.webanimal.rrr.model.Product
import com.webanimal.rrr.repository.ProductsRepository
import com.webanimal.rrr.ui.adapters.ProductsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_favor.*
import kotlinx.android.synthetic.main.fragment_favor.searchButton
import kotlinx.android.synthetic.main.fragment_favor.searchTerm
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.product_row.*
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

//        doAsync {
//            val json = URL("https://run.mocky.io/v3/db6f32b5-a588-4180-b9f1-03ccb48205ac").readText()
//
//            uiThread {
//                Log.d("Main", "json -> $json")
//                val products = Gson().fromJson(json, Array<Product>::class.java).toList()
//
//                root.recycler_view1.apply {
//                    layoutManager = LinearLayoutManager(activity)
//                    adapter = ProductsAdapter(products)
//                    root.progressBar.visibility = View.GONE
//                }
//            }
//        }

//        // Эксперимент

//        searchButton.setOnClickListener {



//        doAsync {
//            val db = Room.databaseBuilder(
//                requireActivity().applicationContext,
//                AppDatabase::class.java, "database-name"
//            ).build()
//
//            val productsFromDatabase = db.productDao().searchFor("%е%")
////            val productsFromDatabase = db.productDao().getAll()
//            val products = productsFromDatabase.map {
//                Product(
//                        it.title,
//                        "https://images.fineartamerica.com/images/artworkimages/mediumlarge/1/1-carnotaurus-vs-antarctopelta-mohamad-haghani.jpg",
//                        "about",
//                        true
//                )
//            }
//
//            uiThread {
//                root.recycler_view1.apply {
//                    layoutManager = LinearLayoutManager(activity)
//                    adapter = ProductsAdapter(products)
//                    root.progressBar.visibility = View.GONE
//                }
//            }
//        }
//
//        root.progressBar.visibility = View.GONE
//    }
        //

        return root
    }

    //Это поиск(2) при нажатии на кнопку - "Искать" , если что - удалить

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productsRepository = ProductsRepository().getAllProducts1()
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
//
//                doAsync {
//
//                    val db = Room.databaseBuilder(
//                            requireActivity().applicationContext,
//                            AppDatabase::class.java, "database-name"
//                    ).build()
//
//                    val productsFromDatabase = db.productDao().searchFor("%${searchTerm.text}%")
////            val productsFromDatabase = db.productDao().getAll()
//                    val products = productsFromDatabase.map {
//                        Product(
//                                it.title,
//                                "https://images.fineartamerica.com/images/artworkimages/mediumlarge/1/1-carnotaurus-vs-antarctopelta-mohamad-haghani.jpg",
//                                "about",
//                                false
//                        )
//                    }
//
//                    uiThread {
//                        recycler_view1.apply {
//                            layoutManager = LinearLayoutManager(activity)
//                            adapter = ProductsAdapter(products)
//                        }
//                        progressBar.visibility = View.GONE
//                    }
//                }
//
//
//        // Эксперимент
//
//
////        root.progressBar.visibility = View.GONE
//
//        //
    }

    //

}