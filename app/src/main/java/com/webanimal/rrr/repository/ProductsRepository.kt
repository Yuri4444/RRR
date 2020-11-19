package com.webanimal.rrr.repository

import com.google.gson.Gson
import com.webanimal.rrr.model.Product
import io.reactivex.Single
import java.net.URL

class ProductsRepository {

    fun getAllProducts1(): Single<List<Product>> {
        return Single.create<List<Product>> {
            val json = URL("https://run.mocky.io/v3/db6f32b5-a588-4180-b9f1-03ccb48205ac").readText()
            val products = Gson().fromJson(json, Array<Product>::class.java).toList()
            it.onSuccess(products)
        }
    }

    fun getAllProducts2(): Single<List<Product>> {
        return Single.create<List<Product>> {
            val json = URL("https://run.mocky.io/v3/f0518056-338b-49a1-9837-11e635151f32").readText()
            val products = Gson().fromJson(json, Array<Product>::class.java).toList()
            it.onSuccess(products)
        }
    }

    fun getAllProducts3(): Single<List<Product>> {
        return Single.create<List<Product>> {
            val json = URL("https://run.mocky.io/v3/3226361e-cb92-423b-882f-72cf9d41992e").readText()
            val products = Gson().fromJson(json, Array<Product>::class.java).toList()
            it.onSuccess(products)
        }
    }

}