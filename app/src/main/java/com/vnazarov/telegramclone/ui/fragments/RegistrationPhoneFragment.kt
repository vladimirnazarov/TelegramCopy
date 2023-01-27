package com.vnazarov.telegramclone.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.vnazarov.telegramclone.R
import kotlinx.android.synthetic.main.fragment_registration_phone.*

class RegistrationPhoneFragment: Fragment(R.layout.fragment_registration_phone) {

    override fun onStart() {
        super.onStart()

        register_button_next.setOnClickListener { sendCode() }
    }

    private fun sendCode(){
        if (register_input_phone.text.toString().isEmpty()){
            Toast.makeText(activity, "Enter your phone number", Toast.LENGTH_SHORT).show()
        } else {
            fragmentManager?.beginTransaction()
                ?.addToBackStack(null)
                ?.replace(R.id.register_data_container, RegistrationCodeFragment())
                ?.commit()
        }
    }
}