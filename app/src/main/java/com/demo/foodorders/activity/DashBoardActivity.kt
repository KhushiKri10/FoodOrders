package com.demo.foodorders.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.demo.foodorders.R
import com.demo.foodorders.databinding.ActivityDashBoardBinding
import com.demo.foodorders.menu.FragmentMenu
import com.demo.foodorders.menu.ViewCartFragment
import com.demo.foodorders.model.StarterItem
import com.demo.foodorders.utils.Utils
import kotlinx.android.synthetic.main.fragment_menu.*

class DashBoardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    lateinit var binding: ActivityDashBoardBinding
    private lateinit var list: ArrayList<StarterItem>

    var totalCount: Int = 0
    var totalItems: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dash_board)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        val fragment: Fragment = FragmentMenu()
        Utils.navigateFragmentWithoutStack(
            false, binding.mainLayout.dashBoard.frmMainContainer.id, supportFragmentManager,
            fragment, FragmentMenu::class.java.name
        )
        navView.setNavigationItemSelectedListener(this)
       binding.mainLayout.dashBoard.fab.setOnClickListener {

       // Toast.makeText(this,""+list.size,Toast.LENGTH_SHORT).show()

            val frag: Fragment = ViewCartFragment()
            val bundle : Bundle = Bundle()
            bundle.putSerializable("list",list)
            frag.arguments = bundle
            Utils.navigateFragmentWithStack(
                false, binding.mainLayout.dashBoard.frmMainContainer.id, supportFragmentManager,
                frag, ViewCartFragment::class.java.name
            )

        }
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        // menuInflater.inflate(R.menu.dash_board, menu)
        return true
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_starter -> {

                val fragment: Fragment = FragmentMenu()
                Utils.navigateFragmentWithoutStack(
                    false, binding.mainLayout.dashBoard.frmMainContainer.id, supportFragmentManager,
                    fragment, FragmentMenu::class.java.name
                )
                //Utils.showShortToast(this,"clicked")
            }
            R.id.nav_main_course -> {
                val fragment: Fragment = FragmentMenu()
                Utils.navigateFragmentWithoutStack(
                    false, binding.mainLayout.dashBoard.frmMainContainer.id, supportFragmentManager,
                    fragment, FragmentMenu::class.java.name
                )
            }
            R.id.nav_desserts -> {
                val fragment: Fragment = FragmentMenu()
                Utils.navigateFragmentWithoutStack(
                    false, binding.mainLayout.dashBoard.frmMainContainer.id, supportFragmentManager,
                    fragment, FragmentMenu::class.java.name
                )
            }
            R.id.nav_drinks -> {
                val fragment: Fragment = FragmentMenu()
                Utils.navigateFragmentWithoutStack(
                    false, binding.mainLayout.dashBoard.frmMainContainer.id, supportFragmentManager,
                    fragment, FragmentMenu::class.java.name
                )
            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun view(list: ArrayList<StarterItem>) {

        this.list = list




    }
}
