package com.dngwjy.infinite.sokongbencana.data.shared

import android.content.Context
import android.os.Build
import android.preference.PreferenceManager
import androidx.annotation.RequiresApi

class Preferences(private val context: Context) {
    companion object {
        private const val LOGGEDIN= "logged"
        private const val USER_ID = "user"
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)
    @RequiresApi(Build.VERSION_CODES.N)
    var userId=preferences.getString(USER_ID,"")
    @RequiresApi(Build.VERSION_CODES.N)
    set(value) = preferences.edit().putString(USER_ID,value).apply()
    @RequiresApi(Build.VERSION_CODES.N)
    var isLogged=preferences.getBoolean(LOGGEDIN,false)
    @RequiresApi(Build.VERSION_CODES.N)
    set(value) = preferences.edit().putBoolean(LOGGEDIN,value).apply()
}