package com.gmail.gromovitaly.telegram_clone.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.databinding.ActivityRegisterBinding
import com.gmail.gromovitaly.telegram_clone.ui.fragments.EnterPhoneFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        toolbar = binding.registerToolbar
        setSupportActionBar(toolbar)
        title = "Your phone"
        supportFragmentManager.beginTransaction()
            .add(R.id.registerDataContainer, EnterPhoneFragment() )
            .commit()
    }
}