package com.pro2on.cryptocurrency.di.module

import com.pro2on.cryptocurrency.data.net.CoinmarketcapApi
import dagger.Module
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Provides
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


/**
 * Created by pro2on on 1/30/18.
 */
@Module
class ApiModule {

    val BASE_URL = "https://api.coinmarketcap.com"


    @Singleton
    @Provides
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }


    @Singleton
    @Provides
    fun provideHttpLoggingInterceptro(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) // was body
    }


    @Singleton
    @Provides
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {

        return OkHttpClient.Builder()
                .connectTimeout((60 * 1000).toLong(), TimeUnit.MILLISECONDS)
                .readTimeout((60 * 1000).toLong(), TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .build()

    }


    @Provides
    @Singleton
    fun provideRetrofit(rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
                        okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build()

    }

    @Provides
    @Singleton
    fun provideCoinMarketcapApi(retrofit: Retrofit): CoinmarketcapApi {
        return retrofit.create(CoinmarketcapApi::class.java)
    }
}