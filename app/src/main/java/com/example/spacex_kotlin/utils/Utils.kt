package com.example.spacex_kotlin.utils

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle


fun Context.isConnectedToNetwork(): Boolean {

    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

    return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting ?: false
}

fun shortDesc(desc: String): String{
    var shorterDesc = desc
    if(desc.length >= 100){
        shorterDesc = desc.substring(0, 99)
        shorterDesc += "..."
    }
     return shorterDesc
}

private val SHARED_PREF_KEY = "app_first_start"
private val SHARED_PREF_FILE = "first_start"

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

fun openNewTabWindow(urls: String, context: Context) {
    val uris = Uri.parse(urls)
    val intents = Intent(Intent.ACTION_VIEW, uris)
    val b = Bundle()
    b.putBoolean("new_window", true)
    intents.putExtras(b)
    context.startActivity(intents)
}