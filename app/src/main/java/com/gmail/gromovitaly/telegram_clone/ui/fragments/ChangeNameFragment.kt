package com.gmail.gromovitaly.telegram_clone.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.gmail.gromovitaly.telegram_clone.MainActivity
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.utilites.*
import kotlinx.android.synthetic.main.fragment_change_name.*


class ChangeNameFragment : Fragment(R.layout.fragment_change_name) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when (item.itemId){
           R.id.settings_confirm_change -> changeName()
       }
        return true
    }

    private fun changeName() {
        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty()) {
            showToast(getString(R.string.name_not_be_empty))
        } else {
            val fullname = "$name $surname" //probel! for split " " in database
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULLNAME)
                .setValue(fullname).addOnCompleteListener {
                    if (it.isSuccessful){
                        showToast(getString(R.string.data_update))
                        USER.fullanmee = fullname
                        fragmentManager?.popBackStack()
                    }
                }

        }
    }
}