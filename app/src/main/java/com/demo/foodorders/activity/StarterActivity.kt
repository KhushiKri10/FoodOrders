package com.demo.foodorders.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.demo.foodorders.R
import com.demo.foodorders.adapter.StarterAdapter
import com.demo.foodorders.model.StarterItem
import com.demo.foodorders.utils.interfaces.ClickEvents
import kotlinx.android.synthetic.main.activity_starter.*

class StarterActivity : AppCompatActivity() , ClickEvents {
    override fun hideCart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun viewCart(list: ArrayList<StarterItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)

        //crating an arraylist to store users using the data class user
        val starter = ArrayList<StarterItem>()

        //adding some dummy data to the list
//        starter.add(StarterItem("Spring roll", 100))
//        starter.add(StarterItem("Pizza", 200))
//        starter.add(StarterItem("Pasta", 300))
//        starter.add(StarterItem("pastass", 400))

        //creating our adapter
        val adapter = StarterAdapter(starter,this, this)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }
}


