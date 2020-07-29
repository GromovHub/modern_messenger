package com.gmail.gromovitaly.telegram_clone.utilites

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.ui.fragments.ChatsFragment

//этот пакет для переделанных функций

fun Fragment.showToast (message: String ) {
    //*** сокращение тоста для фрагментов
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity){
    //*** сокращение интента
    val intent = Intent(this, activity ::class.java) //в случае не соблюдения условий открыветсся окно регистрации
    startActivity(intent)
    this.finish() //выгрузка старого активити из памяти
}

fun AppCompatActivity.replaceFragment(containerViewIdKUDA: Int, fragmentCHTO: Fragment) {
    //*** сокращение вызова фрагмента для из активити
    supportFragmentManager
        .beginTransaction()
        .addToBackStack(null)
        .replace(
            containerViewIdKUDA,
            fragmentCHTO
        ).commit()

}fun Fragment.replaceFragment(containerViewIdKUDA: Int, fragmentCHTO: Fragment) {
    //*** сокращение вызова фрагмента для вызова из фрагмента
    fragmentManager
        ?.beginTransaction()
        ?.addToBackStack(null)
        ?.replace(
            containerViewIdKUDA,
            fragmentCHTO
        )?.commit()
}
