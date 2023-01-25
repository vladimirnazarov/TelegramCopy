package com.vnazarov.telegramclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vnazarov.telegramclone.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment() {

    private lateinit var mBinding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSettingsBinding.inflate(layoutInflater)

        return mBinding.root
    }
}