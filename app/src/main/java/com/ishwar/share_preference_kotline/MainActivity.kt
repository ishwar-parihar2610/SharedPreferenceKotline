package com.ishwar.share_preference_kotline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.ishwar.share_preference_kotline.databinding.ActivityMainBinding
import com.ishwar.share_preference_kotline.util.Constant
import com.ishwar.share_preference_kotline.util.Preference_Manager
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: Preference_Manager
    private val constant = Constant()

    override fun onStart() {
         manager = Preference_Manager()
        manager.initSharePreference(this)
        if (manager.getString(constant.MAIl_KEY) != null) {
            startActivity(Intent(this, home_page::class.java))

        }
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        binding.loginBtn.setOnClickListener {
            val name = binding.emailEdit.text.toString()
            val password = binding.passwordEdit.text.toString()

            Log.d("name ",name)
            Log.d("password ",password)
            manager.putString(constant.MAIl_KEY, name)
            manager.putString(constant.PASSWORD_KEY, password)
            startActivity(Intent(this, home_page::class.java))
        }
    }
}