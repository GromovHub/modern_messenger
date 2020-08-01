package com.gmail.gromovitaly.telegram_clone.ui.fragments

import androidx.fragment.app.Fragment
import com.gmail.gromovitaly.telegram_clone.MainActivity


open class BaseFragment(val layout:Int) : Fragment(layout) {
//в этот класс фрагмент мы вынесли дублирующий код из остальных фрагментов
// ? а потом его удалили

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).mAppDrawer.disableDrawer() //когда запускается фрагмент отличный от фрагмента с чатами, дравер блокируется
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).mAppDrawer.enableDrawer()
        // как только переходим в наследников НЕ базового фрагмента, старые фрагменты стопятся
    }
}