package com.demo.foodorders.menu


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.foodorders.R
import com.demo.foodorders.adapter.CartAdapter
import com.demo.foodorders.databinding.FragmentViewCartBinding
import com.demo.foodorders.model.StarterItem
import kotlinx.android.synthetic.main.fragment_view_cart.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ViewCartFragment : Fragment() {
    lateinit var fragmentViewCartBinding: FragmentViewCartBinding
    private var list: ArrayList<StarterItem> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentViewCartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_cart,
            container, false)

        list = arguments?.getSerializable("list") as ArrayList<StarterItem>


        fragmentViewCartBinding.recycler.adapter = CartAdapter(list,activity!!)

        return fragmentViewCartBinding.root



    }
}
