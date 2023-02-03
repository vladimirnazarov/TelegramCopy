package com.vnazarov.telegramclone.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vnazarov.telegramclone.activities.MainActivity

open class BaseFragment(layout: Int): Fragment(layout) {

    override fun onStart() {
        super.onStart()

        (activity as MainActivity).mAppDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()

        (activity as MainActivity).mAppDrawer.enableDrawer()
    }
}