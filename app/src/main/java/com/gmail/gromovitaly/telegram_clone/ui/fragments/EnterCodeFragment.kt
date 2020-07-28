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
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                val codeValue = register_input_code.text.toString()
                if (codeValue.length == 6) {
                    verifyCode()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

    }

    private fun verifyCode() {
    Toast.makeText(activity, "OK", Toast.LENGTH_SHORT)
    }
}