package com.vnazarov.telegramclone.ui.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.auth.PhoneAuthProvider
import com.vnazarov.telegramclone.MainActivity
import com.vnazarov.telegramclone.R
import com.vnazarov.telegramclone.activities.RegisterActivity
import com.vnazarov.telegramclone.utilits.AUTH
import com.vnazarov.telegramclone.utilits.AppTextWatcher
import com.vnazarov.telegramclone.utilits.replaceActivity
import com.vnazarov.telegramclone.utilits.showToast
import kotlinx.android.synthetic.main.fragment_registration_code.*

class RegistrationCodeFragment(val mPhoneNumber: String, val id: String) : Fragment(R.layout.fragment_registration_code) {

    override fun onStart() {
        super.onStart()

        (activity as RegisterActivity).title = mPhoneNumber

        register_input_code.addTextChangedListener(AppTextWatcher {

            val string = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }

        })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)

        AUTH.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                showToast("Welcome")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else{
                showToast(it.exception?.message.toString())
            }
        }
    }
}