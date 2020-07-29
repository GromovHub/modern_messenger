package com.gmail.gromovitaly.telegram_clone.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.utilites.replaceFragment
import com.gmail.gromovitaly.telegram_clone.utilites.showToast
import kotlinx.android.synthetic.main.fragment_enter_phone.*


class EnterPhoneFragment : Fragment(R.layout.fragment_enter_phone) {



    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener {
            sendCode()
        }

    }

    private fun sendCode() {
        //если поле ввода пустое, то просьба ввести данные
        //если нет, то фрагмент менеджер запускает фрагмент ввода кода из смс
    if (register_input_phone.text.toString().isEmpty()){
        showToast("Enter phone")
    } else {
        replaceFragment(R.id.registerDataContainer, EnterCodeFragment())
    }
    }

}