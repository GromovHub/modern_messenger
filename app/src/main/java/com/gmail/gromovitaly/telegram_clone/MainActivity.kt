package com.gmail.gromovitaly.telegram_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.gmail.gromovitaly.telegram_clone.activities.RegisterActivity
import com.gmail.gromovitaly.telegram_clone.databinding.ActivityMainBinding
import com.gmail.gromovitaly.telegram_clone.ui.fragments.ChatsFragment
import com.gmail.gromovitaly.telegram_clone.ui.objects.AppDrawer
import com.gmail.gromovitaly.telegram_clone.utilites.replaceActivity
import com.gmail.gromovitaly.telegram_clone.utilites.replaceFragment

class MainActivity : AppCompatActivity() {
    // по моим скромным выводам мы добавляем части будущего интерфейса ниже
    private lateinit var mBinding: ActivityMainBinding //это для нул безопасного обращения к элементам вью //аналог синтетики, файндвью или датабиндинга
    private lateinit var mToolbar: Toolbar // это верхняя полоса на экране
    private lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =
            ActivityMainBinding.inflate(layoutInflater) //LayoutInflater это класс, который умеет из содержимого layout-файла создать View-элемент. Метод который это делает называется inflate
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()//сначала инициализируем объекты
        initFunc()//потом какие то функции
    }

    private fun initFunc() {
        if (true){ //?тут я чет не в теме почему фолс //это временный момент. этот буль разрешает вход дальше
            setSupportActionBar(mToolbar) //как я понял этот метод дает нам возможность натянуть на тулбар любую иконку и анимацию
            mAppDrawer.Create()
            replaceFragment(R.id.dataContainer, ChatsFragment()) //это мы вставляем фрагмент с чатами в constraint на главной
        } else {
            replaceActivity(RegisterActivity()) //в случае не соблюдения условий открыветсся окно регистрации
        }
    }



    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar) //подключили класс апдравер в который вынесли код
    }
}
