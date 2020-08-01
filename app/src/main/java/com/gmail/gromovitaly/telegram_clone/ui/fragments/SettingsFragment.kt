package com.gmail.gromovitaly.telegram_clone.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.gmail.gromovitaly.telegram_clone.MainActivity
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.activities.RegisterActivity
import com.gmail.gromovitaly.telegram_clone.databinding.FragmentSettingsBinding
import com.gmail.gromovitaly.telegram_clone.utilites.AUTH
import com.gmail.gromovitaly.telegram_clone.utilites.replaceActivity


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {
    //фрагмент наследуется от базового

    private lateinit var mBinding: FragmentSettingsBinding


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true) //вроде как активация меню из правого верхнего угла
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) { //подключаем меню из правого верхнего угла
        activity?.menuInflater?.inflate(R.menu.menu_settings_action,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.toolbar_dots_exit -> {AUTH.signOut()
            (activity as MainActivity).replaceActivity(RegisterActivity())}
        }
        return true
    }
}