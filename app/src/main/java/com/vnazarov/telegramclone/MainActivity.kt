package com.vnazarov.telegramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.vnazarov.telegramclone.activities.RegisterActivity
import com.vnazarov.telegramclone.databinding.ActivityMainBinding
import com.vnazarov.telegramclone.ui.fragments.ChatsFragment
import com.vnazarov.telegramclone.ui.objects.AppDrawer
import com.vnazarov.telegramclone.utilits.AUTH
import com.vnazarov.telegramclone.utilits.replaceActivity
import com.vnazarov.telegramclone.utilits.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()

        initFields()
        initFunc()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)

        AUTH = FirebaseAuth.getInstance()
    }

    private fun initFunc() {

        if(AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)

            mAppDrawer.create()

            replaceFragment(ChatsFragment())
            
        } else {
            replaceActivity(RegisterActivity())
        }
    }
}