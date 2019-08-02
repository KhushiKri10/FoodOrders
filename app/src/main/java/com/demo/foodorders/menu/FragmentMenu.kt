package com.demo.foodorders.menu


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.foodorders.R
import com.demo.foodorders.activity.DashBoardActivity
import com.demo.foodorders.adapter.StarterAdapter
import com.demo.foodorders.databinding.FragmentMenuBinding
import com.demo.foodorders.model.StarterItem
import com.demo.foodorders.utils.interfaces.ClickEvents
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_menu.view.*

class FragmentMenu : Fragment() , ClickEvents {


    lateinit var fragmentMenuBinding: FragmentMenuBinding
    private lateinit var list: ArrayList<StarterItem>
    var totalCount: Int = 0
    var totalItems: Int = 0
    lateinit var clickEvents:ClickEvents
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMenuBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false);
        /* val starter = ArrayList<StarterItem>()

         //adding some dummy data to the list
         starter.add(StarterItem("Spring roll", 100))
         starter.add(StarterItem("Pizza", 200))
         starter.add(StarterItem("Pasta", 300))
         starter.add(StarterItem("pastass", 400))

         //creating our adapter
         val adapter = StarterAdapter(starter,activity!!.applicationContext)

         //now adding the adapter to recyclerview*/

        val starter = ArrayList<StarterItem>()

        //adding some dummy data to the list
        starter.add(
            StarterItem(
                "Spring roll",
                100,
                "https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                0
            )
        )
        starter.add(
            StarterItem(
                "Spring roll",
                200,
                "https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                0
            )
        )
        starter.add(
            StarterItem(
                "Spring roll",
                300,
                "https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                0
            )
        )
        starter.add(
            StarterItem(
                "Spring roll",
                400,
                "https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                0
            )
        )

        //creating our adapter
        val adapter = StarterAdapter(starter, activity as DashBoardActivity,this)

        //now adding the adapter to recyclerview
//        recyclerView.adapter = adapter


        fragmentMenuBinding.root!!.recyclerView.adapter = adapter




        // Inflate the layout for this fragment
        // mRootView = fragmentMenuBinding.root
        return fragmentMenuBinding.root


    }

    override fun viewCart(l: ArrayList<StarterItem>) {
//        view_cart.visibility = View.VISIBLE
//
//        totalCount = 0
//        totalItems = 0
//

//
//        this.list = list
//        view_cart.setText("View cart " + totalItems + " items")

        list = ArrayList()

        for (i in 0..l.size - 1) {
            if (l.get(i).quantity > 0) {
                list.add(l.get(i))
            }



            if (activity is DashBoardActivity) {
                (activity as DashBoardActivity).view(list)
            }


        }
    }

    override fun hideCart() {
        view_cart.visibility = View.GONE
        view_cart.invalidate()
    }


}