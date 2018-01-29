package com.pro2on.cryptocurrency.di.module

import android.preference.PreferenceManager
import com.pro2on.cryptocurrency.application.CryptoApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by pro2on on 1/23/18.
 */
@Module
class AppModule(val application: CryptoApp) {

    @Provides @Singleton fun provideContext() = application

    @Provides @Singleton fun provideSharedPreferences() = PreferenceManager.getDefaultSharedPreferences(application)

}