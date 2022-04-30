package com.ishwar.share_preference_kotline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ishwar.share_preference_kotline.databinding.ActivityHomePageBinding
import com.ishwar.share_preference_kotline.util.Preference_Manager

class home_page : AppCompatActivity() {
    private  lateinit var binding:ActivityHomePageBinding
    private  lateinit var manager:Preference_Manager

    override fun onStart() {
        manager= Preference_Manager()
        manager.initSharePreference(this)

        super.onStart()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home_page)
        binding.logOutBtn.setOnClickListener {
            manager.clearData()
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}