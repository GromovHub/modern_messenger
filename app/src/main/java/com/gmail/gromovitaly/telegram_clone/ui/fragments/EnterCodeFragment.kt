package com.gmail.gromovitaly.telegram_clone.ui.fragments

import androidx.fragment.app.Fragment
import com.gmail.gromovitaly.telegram_clone.MainActivity
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.activities.RegisterActivity
import com.gmail.gromovitaly.telegram_clone.utilites.AUTH
import com.gmail.gromovitaly.telegram_clone.utilites.AppTextWatcher
import com.gmail.gromovitaly.telegram_clone.utilites.replaceActivity
import com.gmail.gromovitaly.telegram_clone.utilites.showToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment(val PhoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {


    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = PhoneNumber
        //не забывай что ниже сокращенный вотчер
        register_input_code.addTextChangedListener(AppTextWatcher {
                val codeValue = register_input_code.text.toString()
                if (codeValue.length == 6) {
                    enterCode() //если условия выполнены то смотрим что делает ф-ция
                }
        })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
       val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                showToast("Welcome!")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else showToast(task.exception?.message.toString())
        }
    }

}