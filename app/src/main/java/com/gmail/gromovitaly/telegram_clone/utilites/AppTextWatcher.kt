package com.gmail.gromovitaly.telegram_clone.utilites

import android.text.Editable
import android.text.TextWatcher
//тут идет сокращение текствотчера для уменьшения кода во фрагменте
class AppTextWatcher(val Onsuccess : (Editable?) -> Unit) : TextWatcher {
    override fun afterTextChanged(p0: Editable?) {
        Onsuccess(p0)
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }
}