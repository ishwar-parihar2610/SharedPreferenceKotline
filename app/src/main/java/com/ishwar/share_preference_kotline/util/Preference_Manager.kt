package com.ishwar.share_preference_kotline.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences


class Preference_Manager {

    val constant = Constant()
    lateinit var sharedPreferences: SharedPreferences

    fun initSharePreference(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(constant.KEY_PREFERENCE, Context.MODE_PRIVATE)

    }

    // @SuppressLint("CommitPrefEdits")
    fun putString(key: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit();
        editor.putString(key, value)
        editor.apply();

    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun clearData() {
        val editor: SharedPreferences.Editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


}