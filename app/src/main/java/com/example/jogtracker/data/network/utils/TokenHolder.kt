package com.example.jogtracker.data.network.utils

import android.util.Log

object TokenHolder{
     var token:String? = null
     set(value){
         Log.e("TAG", "token was changed on $value")
         field = value
     }
 }