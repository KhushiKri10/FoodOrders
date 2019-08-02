package com.demo.foodorders.utils.interfaces

import com.demo.foodorders.model.StarterItem

interface ClickEvents {
    fun viewCart(list: ArrayList<StarterItem>)
    fun hideCart()
}