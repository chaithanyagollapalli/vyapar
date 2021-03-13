package com.nero.vyapar

import android.content.Context
import android.content.SharedPreferences


object PreferenceHelper {
    private var sharedPreferences: SharedPreferences? = null
    private const val PREF_NAME = "users"
    fun getSharedPreferences(context: Context): SharedPreferences? {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        }
        return sharedPreferences
    }

    fun writeIntToPreference(key: String?, value: Int) {
        val editor = sharedPreferences!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun writeBooleanToPreference(key: String?, value: Boolean) {
        val editor = sharedPreferences!!.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun writeStringToPreference(key: String?, value: String?) {
        val editor = sharedPreferences!!.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getIntFromPreference(key: String?): Int {
        return sharedPreferences!!.getInt(key, 0)
    }

    fun getBooleanFromPreference(key: String?): Boolean {
        return sharedPreferences!!.getBoolean(key, false)
    }

    fun getStringFromPreference(key: String?): String? {
        return sharedPreferences!!.getString(key, "")
    }
}