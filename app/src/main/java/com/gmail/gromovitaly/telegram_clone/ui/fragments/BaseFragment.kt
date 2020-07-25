package com.gmail.gromovitaly.telegram_clone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.gromovitaly.telegram_clone.R


open class BaseFragment(val layout:Int) : Fragment() {
//в этот класс фрагмент мы вынесли дублирующий код из остальных фрагментов
private lateinit var mRootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       mRootView = inflater.inflate(layout,container,false)
        return mRootView
    }

    override fun onStart() {
        super.onStart()
    }
}