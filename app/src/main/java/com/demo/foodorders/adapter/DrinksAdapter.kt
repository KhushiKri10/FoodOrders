package com.demo.foodorders.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.foodorders.R
import com.demo.foodorders.databinding.CustomRowProductLayoutBinding
import com.demo.foodorders.model.StarterItem

class DrinksAdapter(val userList: ArrayList<StarterItem>) : RecyclerView.Adapter<DrinksAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksAdapter.ViewHolder {
        val v: View = DataBindingUtil.inflate<CustomRowProductLayoutBinding>(
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
            R.layout.custom_row_product_layout,
            parent,
            false
        ).root
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: DrinksAdapter.ViewHolder, position: Int) {
        holder.getBinding().setStarterList(userList.get(position))
        holder.getBinding().tvPrice.text = "Price:" + userList.get(position).price.toString()
        holder.getBinding().imgPlus.setOnClickListener {


        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rowBinding: CustomRowProductLayoutBinding

        init {
            super.itemView
            rowBinding = DataBindingUtil.bind(itemView)!!
        }


        fun getBinding(): CustomRowProductLayoutBinding {
            return rowBinding
        }

    }
}