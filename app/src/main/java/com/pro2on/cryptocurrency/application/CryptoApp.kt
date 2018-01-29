package com.pro2on.cryptocurrency.application

import android.app.Application
import com.pro2on.cryptocurrency.BuildConfig
import com.pro2on.cryptocurrency.di.AppComponent
import com.pro2on.cryptocurrency.di.DaggerAppComponent
import com.pro2on.cryptocurrency.di.module.AppModule
import com.pro2on.cryptocurrency.di.module.DataModule
import timber.log.Timber

/**
 * Created by pro2on on 1/23/18.
 */
class CryptoApp : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .dataModule(DataModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


}