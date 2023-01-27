package com.vnazarov.telegramclone.ui.fragments

import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.vnazarov.telegramclone.R
import kotlinx.android.synthetic.main.fragment_registration_code.*

class RegistrationCodeFragment: Fragment(R.layout.fragment_registration_code) {

    override fun onStart() {
        super.onStart()

        register_input_code.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                val string = register_input_code.text.toString()
                if (string.length == 6){
                    verifyCode()
                }
            }

        })
    }

    fun verifyCode(){
        Toast.makeText(activity, "Ok", Toast.LENGTH_SHORT).show()
    }
}