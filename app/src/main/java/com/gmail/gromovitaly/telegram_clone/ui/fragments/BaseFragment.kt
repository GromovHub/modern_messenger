package com.gmail.gromovitaly.telegram_clone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.gromovitaly.telegram_clone.R


open class BaseFragment(val layout:Int) : Fragment(layout) {
//в этот класс фрагмент мы вынесли дублирующий код из остальных фрагментов
// ? а потом его удалили

    override fun onStart() {
        super.onStart()
    }
}