package com.vnazarov.telegramclone.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.vnazarov.telegramclone.R
import com.vnazarov.telegramclone.utilits.replaceFragment
import com.vnazarov.telegramclone.utilits.showToast
import kotlinx.android.synthetic.main.fragment_registration_phone.*

class RegistrationPhoneFragment: Fragment(R.layout.fragment_registration_phone) {

    override fun onStart() {
        super.onStart()

        register_button_next.setOnClickListener { sendCode() }
    }

    private fun sendCode(){
        if (register_input_phone.text.toString().isEmpty()){
            showToast("Enter your phone number")
        } else {
            replaceFragment(RegistrationCodeFragment())
        }
    }
}