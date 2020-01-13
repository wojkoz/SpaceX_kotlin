package com.example.spacex_kotlin.utils

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.example.spacex_kotlin.repository.model.retrofit.FirstStage
import com.example.spacex_kotlin.repository.model.retrofit.SecondStage


fun makeFirstStageReadable(stage: FirstStage): String{
    return "\tBurn Time: ${stage.burnTimeSec}\n\tEngines: ${stage.engines}\n\tFuel amount (tons): ${stage.fuelAmountTons}\n\tReusable: ${stage.reusable}"
}

fun makeSecondStageReadable(stage: SecondStage): String{
    return "\tBurn Time: ${stage.burnTimeSec}\n\tEngines: ${stage.engines}\n\tFuel amount (tons): ${stage.fuelAmountTons}"
}

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
const val NO_INTERNET_CONNECTION = "No internet connection"
private const val SHARED_PREF_KEY = "Aapp_first_start"
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
