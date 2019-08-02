package com.demo.foodorders.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.demo.foodorders.R
import com.demo.foodorders.databinding.CartBinding
import com.demo.foodorders.model.StarterItem


class CartAdapter(val userList: ArrayList<StarterItem>, val context: Context) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    private var itemCount: Int = 0

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = DataBindingUtil.inflate<CartBinding>(
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
            R.layout.cart,
            parent,
            false
        ).root
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val starterItem = userList.get(position)
        holder.getBinding().setStarterList(starterItem)
        holder.getBinding().tvPrice.text = "Price:" + starterItem.price.toString()
        holder.getBinding().itemValue.text = "Q :"+starterItem.quantity
        Glide.with(context).load(starterItem.img).into(holder.getBinding().imgProduct)




    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rowBinding: CartBinding

        init {
            super.itemView
            rowBinding = DataBindingUtil.bind(itemView)!!
        }

        fun getBinding(): CartBinding {
            return rowBinding
        }
    }

}