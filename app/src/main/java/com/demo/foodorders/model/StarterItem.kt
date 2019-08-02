package com.demo.foodorders.model
import java.io.Serializable

data class StarterItem(val name: String, val price: Int, val img:String, var quantity: Int)  : Serializable