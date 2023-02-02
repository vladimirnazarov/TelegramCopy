package com.vnazarov.telegramclone.ui.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.auth.PhoneAuthProvider
import com.vnazarov.telegramclone.activities.MainActivity
import com.vnazarov.telegramclone.R
import com.vnazarov.telegramclone.activities.RegisterActivity
import com.vnazarov.telegramclone.utilits.*
import kotlinx.android.synthetic.main.fragment_registration_code.*

class RegistrationCodeFragment(private val mPhoneNumber: String, val id: String) : Fragment(R.layout.fragment_registration_code) {

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

        AUTH.signInWithCredential(credential).addOnCompleteListener { task1 ->
            if (task1.isSuccessful){

                val uid = AUTH.currentUser?.uid.toString()
                val dataMap = mutableMapOf<String, Any>()
                dataMap[CHILD_ID] = uid
                dataMap[CHILD_PHONE] = mPhoneNumber
                dataMap[CHILD_USERNAME] = uid

                REF_DATABASE_ROOT.child(NODE_USERS).child(uid).updateChildren(dataMap).addOnCompleteListener { task2 ->
                    if (task2.isSuccessful){
                        showToast("Welcome")
                        (activity as RegisterActivity).replaceActivity(MainActivity())
                    } else {
                        showToast(task2.exception?.message.toString())
                    }
                }

            } else{
                showToast(task1.exception?.message.toString())
            }
        }
    }
}