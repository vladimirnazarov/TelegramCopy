package com.vnazarov.telegramclone.ui.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.vnazarov.telegramclone.MainActivity
import com.vnazarov.telegramclone.R
import com.vnazarov.telegramclone.activities.RegisterActivity
import com.vnazarov.telegramclone.utilits.replaceActivity
import com.vnazarov.telegramclone.utilits.replaceFragment
import com.vnazarov.telegramclone.utilits.showToast
import kotlinx.android.synthetic.main.fragment_registration_phone.*
import java.util.concurrent.TimeUnit

class RegistrationPhoneFragment: Fragment(R.layout.fragment_registration_phone) {

    private lateinit var mPhoneNumber: String
    private lateinit var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private lateinit var mAuth: FirebaseAuth

    override fun onStart() {
        super.onStart()

        mAuth = FirebaseAuth.getInstance()

        mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                mAuth.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful){
                        showToast("Welcome")
                        (activity as RegisterActivity).replaceActivity(MainActivity())
                    } else{
                        showToast(it.exception?.message.toString())
                    }
                }
            }

            override fun onVerificationFailed(m: FirebaseException) {
                showToast(m.message.toString())
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                replaceFragment(RegistrationCodeFragment(mPhoneNumber, id))
            }
        }

        register_button_next.setOnClickListener { sendCode() }
    }

    private fun sendCode(){
        if (register_input_phone.text.toString().isEmpty()){
            showToast("Enter your phone number")
        } else {
            authUser()
        }
    }

    private fun authUser(){
        mPhoneNumber = register_input_phone.text.toString()
        val options = PhoneAuthOptions.newBuilder()
            .setPhoneNumber(mPhoneNumber)
            .setTimeout(60, TimeUnit.SECONDS)
            .setActivity(activity as RegisterActivity)
            .setCallbacks(mCallback)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}