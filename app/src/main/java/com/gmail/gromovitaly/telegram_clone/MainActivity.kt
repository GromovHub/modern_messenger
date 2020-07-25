package com.gmail.gromovitaly.telegram_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.gmail.gromovitaly.telegram_clone.databinding.ActivityMainBinding
import com.gmail.gromovitaly.telegram_clone.ui.fragments.ChatsFragment
import com.gmail.gromovitaly.telegram_clone.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {
    // по моим скромным выводам мы добавляем части будущего интерфейса ниже
    private lateinit var mBinding: ActivityMainBinding //это для нул безопасного обращения к элементам вью
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
        setSupportActionBar(mToolbar) //как я понял этот метод дает нам возможность натянуть на тулбар любую иконку и анимацию

        mAppDrawer.Create()

        supportFragmentManager.beginTransaction() //это мы вставляем фрагмент с чатами в constraint на главной
            .replace(R.id.dataContainer,
                ChatsFragment()
            ).commit()


    }



    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar) //подключили класс апдравер в который вынесли код
    }
}
