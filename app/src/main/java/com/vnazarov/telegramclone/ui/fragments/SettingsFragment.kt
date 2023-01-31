package com.vnazarov.telegramclone.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.vnazarov.telegramclone.MainActivity
import com.vnazarov.telegramclone.R
import com.vnazarov.telegramclone.activities.RegisterActivity
import com.vnazarov.telegramclone.utilits.AUTH
import com.vnazarov.telegramclone.utilits.replaceActivity

class SettingsFragment: BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)

        (activity as MainActivity).title = "Settings"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }
}