package com.gmail.gromovitaly.telegram_clone.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.databinding.FragmentSettingsBinding


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
}