package com.webanimal.rrr.ui.fragments

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.room.Room
import com.webanimal.rrr.R
import com.webanimal.rrr.database.AppDatabase
import com.webanimal.rrr.database.ProductFromDatabase
import kotlinx.android.synthetic.main.fragment_favor.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class FavorFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_favor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchButton.setOnClickListener {

            val title = searchTerm.text
            Toast.makeText(activity, "Search $title!", Toast.LENGTH_SHORT).show()

            doAsync {
                val db = Room.databaseBuilder(
                        requireActivity().applicationContext,
                        AppDatabase::class.java, "database-name"
                ).build()

            db.productDao().insertAll(ProductFromDatabase(null, title.toString(), 9.99))

                uiThread {
                    d("products", "Common!")
                }
            }
        }
    }
}