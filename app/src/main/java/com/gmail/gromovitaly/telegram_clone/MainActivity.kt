package com.gmail.gromovitaly.telegram_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.gmail.gromovitaly.telegram_clone.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem

class MainActivity : AppCompatActivity() {
    // по моим скромным выводам мы добавляем части будущего интерфейса ниже
    private lateinit var mBinding: ActivityMainBinding //это для нул безопасного обращения к элементам вью
    private lateinit var mDrawer: Drawer //это вылетающее меню слева
    private lateinit var mHeader: AccountHeader // это шапка с картинкой в вылетающем меню
    private lateinit var mToolbar: Toolbar // это верхняя полоса на экране

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater) //LayoutInflater это класс, который умеет из содержимого layout-файла создать View-элемент. Метод который это делает называется inflate
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()//сначала инициализируем объекты
        initFunc()//потом какие то функции
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar) //как я понял этот метод дает нам возможность натянуть на тулбар любую иконку и анимацию
        createHeader()//создаем хедер собсна (картинка в меню)
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(mToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems( //samo menu
                PrimaryDrawerItem()
                    .withIdentifier(100)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("Создать группу")
                    .withSelectable(false)
            ).build()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder() //получается в сторонней библиотеке есть конструктор который сам все красиво нарисует и расположит по местам
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)//цвет для картинки в меню
            .addProfiles( //это часть конструктора
                ProfileDrawerItem().withName("Vitaly").withEmail("mymail@gmail.com")
            ).build()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
    }
}
