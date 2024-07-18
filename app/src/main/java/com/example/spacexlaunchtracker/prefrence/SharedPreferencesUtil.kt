package com.example.spacexlaunchtracker.prefrence

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesUtil {

    private const val PREFS_NAME = "MyPrefs"
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun saveString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun contains(key: String) : Boolean{
        return sharedPreferences.contains(key)
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun removeKey(key: String) {
        editor.remove(key)
        editor.apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value).apply()
    }

    fun remove(key: String) {
        editor.remove(key).apply()
    }

    fun clear() {
        editor.clear()
        editor.apply()
    }

}
