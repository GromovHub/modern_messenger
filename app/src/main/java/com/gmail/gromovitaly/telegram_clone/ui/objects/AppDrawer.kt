package com.gmail.gromovitaly.telegram_clone.ui.objects

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.gmail.gromovitaly.telegram_clone.R
import com.gmail.gromovitaly.telegram_clone.ui.fragments.SettingsFragment
import com.gmail.gromovitaly.telegram_clone.utilites.replaceFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer(
    val mainActivity: AppCompatActivity,
    val toolbar: androidx.appcompat.widget.Toolbar
) {

    private lateinit var mDrawer: Drawer //это вылетающее меню слева
    private lateinit var mHeader: AccountHeader // это шапка с картинкой в вылетающем меню
    private lateinit var mDrawerLayout: DrawerLayout

    fun Create() {
        createHeader()//создаем хедер собсна (картинка в меню)
        createDrawer()//создаем левое меню
        mDrawerLayout = mDrawer.drawerLayout
    }

    fun disableDrawer() {
        mDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = false
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.setNavigationOnClickListener {
            mainActivity.supportFragmentManager.popBackStack()
        }
    }

    fun enableDrawer() {
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mDrawer.actionBarDrawerToggle?.isDrawerIndicatorEnabled = true
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        toolbar.setNavigationOnClickListener {
            mDrawer.openDrawer()
        }
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems( //samo menu
                PrimaryDrawerItem()
                    .withIdentifier(101)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("New Group")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_groups),
                PrimaryDrawerItem()
                    .withIdentifier(102)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("New Secret Chat")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_secret_chat),
                PrimaryDrawerItem()
                    .withIdentifier(103)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("New Channel")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_channel),
                PrimaryDrawerItem()
                    .withIdentifier(104)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("Contacts")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_contacts),
                PrimaryDrawerItem()
                    .withIdentifier(105)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("Calls")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_phone),
                PrimaryDrawerItem()
                    .withIdentifier(106)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("Saved Messages")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_favorites),
                PrimaryDrawerItem()
                    .withIdentifier(107)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("Settings")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_settings),

                DividerDrawerItem(), //delitel

                PrimaryDrawerItem()
                    .withIdentifier(108)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("Invite Friends")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_invate),
                PrimaryDrawerItem()
                    .withIdentifier(108)//vrode nomer elementa v menu
                    .withIconTintingEnabled(true)
                    .withName("Telegram FAQ")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_help)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick( //слушатель нажатий на каждый пункт меню
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    Toast.makeText(
                        mainActivity,
                        "${position}",
                        Toast.LENGTH_SHORT
                    ).show()

                    when (position) {
                        7 -> mainActivity.replaceFragment(
                            R.id.dataContainer,
                            SettingsFragment()
                        )
                    }

                    return false
                }
            }).build()
    }

    private fun createHeader() {
        mHeader =
            AccountHeaderBuilder() //получается в сторонней библиотеке есть конструктор который сам все красиво нарисует и расположит по местам
                .withActivity(mainActivity)
                .withHeaderBackground(R.drawable.header)//цвет для картинки в меню
                .addProfiles( //это часть конструктора
                    ProfileDrawerItem().withName("Vitaly").withEmail("mymail@gmail.com")
                ).build()
    }
}