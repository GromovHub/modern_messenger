package com.gmail.gromovitaly.telegram_clone.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.utilites.AppTextWatcher
import com.gmail.gromovitaly.telegram_clone.utilites.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        //не забывай что ниже сокращенный вотчер
        register_input_code.addTextChangedListener(AppTextWatcher {
                val codeValue = register_input_code.text.toString()
                if (codeValue.length == 6) {
                    verifyCode() //если условия выполнены то смотрим что делает ф-ция
                }
        })
    }

    private fun verifyCode() {
    showToast("OK") //это сокращенный тост только для фрагментов
    }
}