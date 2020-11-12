package com.webanimal.rrr

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.webanimal.rrr.banzay.ExampleStateAdapterWithFragments
import kotlinx.android.synthetic.main.activity_main.*

//https://i.pinimg.com/originals/6d/9c/fe/6d9cfe40d090a18aa34f1676baf6c37a.jpg
//https://sand-box.com.ua/image/cache/data/trafaret/trafaret-a6-dinozavr-4730-500x500_0.jpg
//https://i.pinimg.com/originals/6f/9e/ac/6f9eac641b6214ff64d62050c65ae8b5.jpg
class MainActivity : AppCompatActivity() {

//    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

//        navController = Navigation.findNavController(this, R.id.nav_host)

        initViewPagerWithFragments()
          //Раковая опухоль
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.AllFragmentsNav, MainFragment())
//            .commit()

//        Для закрытия панели
        navigationView.setNavigationItemSelectedListener {
//            when(it.itemId) {
//                R.id.allDino -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.AllFragmentsNav, MainFragment())
//                        .commit()
//                }
//                R.id.plant -> Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
//                R.id.earth -> Toast.makeText(this, "$it" , Toast.LENGTH_SHORT).show()
//                R.id.records -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.AllFragmentsNav, RecordsFragment())
//                        .commit()
//
//                    Toast.makeText(this, "$it" , Toast.LENGTH_SHORT).show()
//                }
//                R.id.finds -> Toast.makeText(this, "$it" , Toast.LENGTH_SHORT).show()
//            }



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

        val names : ArrayList<String> = arrayListOf("Главная", "Триас", "Юрский", "Меловой")

        val tabLayout : TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            tab.text = names[position]
        }.attach()
    }

}