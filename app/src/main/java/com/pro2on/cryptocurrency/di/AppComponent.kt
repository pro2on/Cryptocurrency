package com.pro2on.cryptocurrency.di

import com.pro2on.cryptocurrency.di.module.AppModule
import com.pro2on.cryptocurrency.di.module.DataModule
import com.pro2on.cryptocurrency.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by pro2on on 1/23/18.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}