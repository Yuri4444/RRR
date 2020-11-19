package com.webanimal.rrr

import android.os.Bundle
import android.util.Log.d
import android.util.Log.e
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.webanimal.rrr.database.AppDatabase
import com.webanimal.rrr.database.ProductFromDatabase
import com.webanimal.rrr.ui.adapters.ExampleStateAdapterWithFragments
import com.webanimal.rrr.ui.fragments.EarthFragment
import com.webanimal.rrr.ui.fragments.FavorFragment
import com.webanimal.rrr.ui.fragments.PlantFragment
import com.webanimal.rrr.ui.fragments.RecordsFragment
import com.webanimal.rrr.ui.fragmentsERAS.MainFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

//https://i.pinimg.com/originals/6d/9c/fe/6d9cfe40d090a18aa34f1676baf6c37a.jpg
//https://sand-box.com.ua/image/cache/data/trafaret/trafaret-a6-dinozavr-4730-500x500_0.jpg
//https://i.pinimg.com/originals/6f/9e/ac/6f9eac641b6214ff64d62050c65ae8b5.jpg
class MainActivity : AppCompatActivity() {

//    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        // Эксперимент
        doAsync {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).build()

//            db.productDao().insertAll(ProductFromDatabase(null, "Рекс", 9.99))
//            db.productDao().delete(ProductFromDatabase(13, "е", 1.99))
//            db.productDao().delete(ProductFromDatabase(10, "е", 1.99))
            val products = db.productDao().getAll()



            uiThread {
                d("products", "${products.size} ${products[0].title}")
            }
        }


        initViewPagerWithFragments()
          //Раковая опухоль
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.AllFragmentsNav, MainFragment())
//            .commit()

//        Для закрытия панели

        //Для вызова поиска через FrameLayout

//        fab.setOnClickListener {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.field_search, FavorFragment())
//            .commit()
//
//            Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show()
//        }

        //

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.allDino -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.AllFragmentsNav, MainFragment())
                        .commit()

                }
                R.id.plant -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.AllFragmentsNav, PlantFragment())
                            .commit()
                    Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
                }
                R.id.earth -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.AllFragmentsNav, EarthFragment())
                        .commit()
                    Toast.makeText(this, "$it" , Toast.LENGTH_SHORT).show()
                }

                R.id.records -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.AllFragmentsNav, RecordsFragment())
                        .commit()

                    Toast.makeText(this, "$it" , Toast.LENGTH_SHORT).show()
                }
                R.id.finds -> Toast.makeText(this, "$it" , Toast.LENGTH_SHORT).show()

                R.id.favor -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.AllFragmentsNav, FavorFragment())
                            .commit()
                }
            }



            it.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

//        Для кнопки - бургера
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        //Експеримент картинки
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.itemIconTintList = null

    }

    //Для открытия панели по нажатию на бургер
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawerLayout.openDrawer(GravityCompat.START)
            return true
//        return super.onOptionsItemSelected(item)
    }

    //Мудрю с фрагментами
    private fun initViewPagerWithFragments() {
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ExampleStateAdapterWithFragments(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val names : ArrayList<String> = arrayListOf("Главная", "Триас. период", "Юрский период", "Меловой период")

        val tabLayout : TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            tab.text = names[position]
        }.attach()
    }

}