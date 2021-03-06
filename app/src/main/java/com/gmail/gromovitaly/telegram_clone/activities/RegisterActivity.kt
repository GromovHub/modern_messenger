package com.gmail.gromovitaly.telegram_clone.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.databinding.ActivityRegisterBinding
import com.gmail.gromovitaly.telegram_clone.ui.fragments.EnterPhoneFragment
import com.gmail.gromovitaly.telegram_clone.utilites.initFirebase
import com.gmail.gromovitaly.telegram_clone.utilites.replaceFragment

//это получился второй активити для модуля регистрации
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        toolbar = binding.registerToolbar
        setSupportActionBar(toolbar)
        title = "Your phone"
        replaceFragment(R.id.registerDataContainer, EnterPhoneFragment(), false) //без добавления в стэк
    }
}