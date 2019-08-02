package com.demo.foodorders.adapter

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.demo.foodorders.R
import com.demo.foodorders.activity.DashBoardActivity
import com.demo.foodorders.activity.StarterActivity
import com.demo.foodorders.databinding.CustomRowProductLayoutBinding
import com.demo.foodorders.model.StarterItem
import com.demo.foodorders.utils.interfaces.ClickEvents


class StarterAdapter(val userList: ArrayList<StarterItem>, val context: Context,val click:ClickEvents) :
    RecyclerView.Adapter<StarterAdapter.ViewHolder>() {
    private var itemCount: Int = 0
    private lateinit var clickEvents : ClickEvents
    init {
        this.clickEvents = click
    }
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarterAdapter.ViewHolder {
        val v: View = DataBindingUtil.inflate<CustomRowProductLayoutBinding>(
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
            R.layout.custom_row_product_layout,
            parent,
            false
        ).root
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: StarterAdapter.ViewHolder, position: Int) {



        val starterItem  = userList.get(position)
        holder.getBinding().setStarterList(starterItem)
        holder.getBinding().tvPrice.text = "Price:" + starterItem.price.toString()
        Glide.with(context).load(starterItem.img).into(holder.getBinding().imgProduct)


        holder.getBinding().btnAdd.setOnClickListener {



            userList[position].quantity = userList.get(position).quantity +1




            // itemCount = Integer.parseInt(holder.getBinding().itemValue.getText().toString()) + 1
            holder.getBinding().imgPlus.visibility = View.VISIBLE
            holder.getBinding().imgMinus.visibility = View.VISIBLE
            holder.getBinding().itemValue.visibility = View.VISIBLE
            holder.getBinding().btnAdd.visibility = View.GONE

            holder.getBinding().itemValue.text = (userList.get(position).quantity.toString())

            if (context is DashBoardActivity){
                clickEvents.viewCart(userList)
               // context.viewCart(userList)
            }




        }

        holder.getBinding().imgPlus.setOnClickListener {

            userList[position].quantity = userList.get(position).quantity +1

            // Utils.showShortToast(context, "clicked")

            if (userList.get(position).quantity > 20) {
                holder.getBinding().imgPlus.setEnabled(false)
                holder.getBinding().imgPlus.setClickable(false)


            }else if (userList.get(position).quantity == 0){
                holder.getBinding().imgPlus.visibility = View.GONE
                holder.getBinding().imgMinus.visibility = View.GONE
                holder.getBinding().itemValue.visibility = View.GONE
                holder.getBinding().btnAdd.visibility = View.VISIBLE
            }else {
                holder.getBinding().itemValue.text = (userList.get(position).quantity.toString())
            }

            if (context is DashBoardActivity){
                clickEvents.viewCart(userList)
            }

        }

        holder.getBinding().imgMinus.setOnClickListener {
            // if (!holder.getBinding().itemValue.getText().toString().equals("0")) {

            userList[position].quantity = userList.get(position).quantity  - 1

            if (userList.get(position).quantity < 20) {

//                    holder.getBinding().imgPlus.setEnabled(true)
//                    holder.getBinding().imgPlus.setClickable(true)
                if (userList.get(position).quantity == 0) {
                    holder.getBinding().imgPlus.visibility = View.GONE
                    holder.getBinding().imgMinus.visibility = View.GONE
                    holder.getBinding().itemValue.visibility = View.GONE
                    holder.getBinding().btnAdd.visibility = View.VISIBLE
                    if (context is DashBoardActivity){
                        clickEvents.hideCart()
                    }
                } else {
                    holder.getBinding().imgPlus.setEnabled(true)
                    holder.getBinding().imgPlus.setClickable(true)
                }
                if (context is DashBoardActivity){
                    clickEvents.viewCart(userList)
                }

            }

            holder.getBinding().itemValue.text = (userList.get(position).quantity.toString())
            //}
//        else {
//                holder.getBinding().itemValue.text = (itemCount.toString())
//            }

        }
       /* holder.getBinding().setStarterList(userList.get(position))
        holder.getBinding().tvPrice.text = "Price:" + userList.get(position).price.toString()

        holder.getBinding().btnAdd.setOnClickListener {
            itemCount = Integer.parseInt(holder.getBinding().itemValue.getText().toString()) + 1
            holder.getBinding().imgPlus.visibility = View.VISIBLE
            holder.getBinding().imgMinus.visibility = View.VISIBLE
            holder.getBinding().itemValue.visibility = View.VISIBLE
            holder.getBinding().btnAdd.visibility = View.GONE


        }

        holder.getBinding().imgPlus.setOnClickListener {
            itemCount = Integer.parseInt(holder.getBinding().itemValue.getText().toString()) + 1
            // Utils.showShortToast(context, "clicked")

            if (itemCount > 20) {
                holder.getBinding().imgPlus.setEnabled(false)
                holder.getBinding().imgPlus.setClickable(false)


            } else {
                holder.getBinding().itemValue.text = (itemCount.toString())
            }
            sendBroadCast()

        }

        holder.getBinding().imgMinus.setOnClickListener {
            if (!holder.getBinding().itemValue.getText().toString().equals("1")) {

                itemCount = Integer.parseInt(holder.getBinding().itemValue.getText().toString()) - 1

                if (itemCount < 20) {

                    holder.getBinding().imgPlus.setEnabled(true)
                    holder.getBinding().imgPlus.setClickable(true)

                }

                holder.getBinding().itemValue.text = (itemCount.toString())
            } else {
                holder.getBinding().imgPlus.visibility = View.GONE
                holder.getBinding().imgMinus.visibility = View.GONE
                holder.getBinding().itemValue.visibility = View.GONE
                holder.getBinding().btnAdd.visibility = View.VISIBLE
                //holder.getBinding().itemValue.text = (itemCount.toString())
            }
            sendBroadCast()

        }*/
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