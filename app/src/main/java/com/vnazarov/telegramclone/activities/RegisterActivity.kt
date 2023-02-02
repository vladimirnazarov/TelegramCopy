package com.vnazarov.telegramclone.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.vnazarov.telegramclone.R
import com.vnazarov.telegramclone.databinding.ActivityRegisterBinding
import com.vnazarov.telegramclone.ui.fragments.RegistrationPhoneFragment
import com.vnazarov.telegramclone.utilits.initFireBase
import com.vnazarov.telegramclone.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var mbinding: ActivityRegisterBinding
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        initFireBase()
    }

    override fun onStart() {
        super.onStart()

        mToolbar = mbinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = "Your phone"

        replaceFragment(RegistrationPhoneFragment(), false)
    }
}