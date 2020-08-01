package com.gmail.gromovitaly.telegram_clone.ui.fragments

import androidx.fragment.app.Fragment
import com.gmail.gromovitaly.telegram_clone.MainActivity
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.activities.RegisterActivity
import com.gmail.gromovitaly.telegram_clone.utilites.AUTH
import com.gmail.gromovitaly.telegram_clone.utilites.replaceActivity
import com.gmail.gromovitaly.telegram_clone.utilites.replaceFragment
import com.gmail.gromovitaly.telegram_clone.utilites.showToast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_enter_phone.*
import java.util.concurrent.TimeUnit


class EnterPhoneFragment : Fragment(R.layout.fragment_enter_phone) {

    private lateinit var mPhoneNumber: String
    private lateinit var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks




    override fun onStart() {
        super.onStart()
        mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showToast("Welcome!")
                        (activity as RegisterActivity).replaceActivity(MainActivity())
                    } else showToast(task.exception?.message.toString())
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                replaceFragment(R.id.registerDataContainer, EnterCodeFragment(mPhoneNumber,id)) //? какие то костыли //протупил вставил не в тот активити
            }
        }

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
        authUser()
    }
    }

    private fun authUser() {
        mPhoneNumber = register_input_phone.text.toString() //введенный номер
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            mPhoneNumber,
            60,
            TimeUnit.SECONDS,
            activity as RegisterActivity,
            mCallback

        )

    }

}