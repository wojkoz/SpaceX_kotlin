package com.example.spacex_kotlin.utils

import android.content.Context
import android.net.ConnectivityManager

fun Context.isConnectedToNetwork(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting() ?: false
}

fun shortDesc(desc: String): String{
    var shorterDesc = desc
    if(desc.length >= 100){
        shorterDesc = desc.substring(0, 99)
        shorterDesc += "..."
    }
     return shorterDesc
}