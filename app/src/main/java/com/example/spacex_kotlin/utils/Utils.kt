package com.example.spacex_kotlin.utils

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager



fun Context.isConnectedToNetwork(): Boolean {

    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

    return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting ?: false
}

fun makeShortDesc(desc: String): String{
    var shorterDesc = desc
    if(desc.length >= 100){
        shorterDesc = desc.substring(0, 99)
        shorterDesc += "..."
    }
     return shorterDesc
}

private const val SHARED_PREF_KEY = "app_first_start"
private const val SHARED_PREF_FILE = "first_start"

fun saveSharedPreferencesFirstStartApp(context: Context){
    val sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, Context.MODE_PRIVATE)

    val editor: SharedPreferences.Editor = sharedPref.edit()

    editor.putBoolean(SHARED_PREF_KEY, false)

    editor.apply()
}

fun retriveSharedPreferencesFirstStartApp(context: Context): Boolean{
    val sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, Context.MODE_PRIVATE)

    return sharedPref.getBoolean(SHARED_PREF_KEY, true)
}

fun makeShortDate(date: String): String = date.substring(0,10)

fun getVideoId(url: String): String = url.substringAfter('=')