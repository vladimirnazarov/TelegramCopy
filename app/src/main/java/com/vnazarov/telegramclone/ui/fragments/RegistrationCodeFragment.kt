package com.vnazarov.telegramclone.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.vnazarov.telegramclone.R
import com.vnazarov.telegramclone.utilits.AppTextWatcher
import com.vnazarov.telegramclone.utilits.showToast
import kotlinx.android.synthetic.main.fragment_registration_code.*

class RegistrationCodeFragment(mPhoneNumber: String, id: String) : Fragment(R.layout.fragment_registration_code) {

    override fun onStart() {
        super.onStart()

        register_input_code.addTextChangedListener(AppTextWatcher {

            val string = register_input_code.text.toString()
            if (string.length == 6) {
                verifyCode()
            }

        })
    }

    private fun verifyCode() {
        showToast("Ok")
    }
}