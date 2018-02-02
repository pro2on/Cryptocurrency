package com.pro2on.cryptocurrency.di.module

import com.pro2on.cryptocurrency.data.entity.mapper.CryptoEntityDataMapper
import com.pro2on.cryptocurrency.data.net.CoinmarketResponseItemMapper
import com.pro2on.cryptocurrency.data.net.CoinmarketcapApi
import com.pro2on.cryptocurrency.data.repository.CryptoDataDemoRepository
import com.pro2on.cryptocurrency.data.repository.CryptoDataRepository
import com.pro2on.cryptocurrency.domain.repository.CryptoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by pro2on on 1/28/18.
 */
@Module
class DataModule {

    // We create a demo repository for now
    @Provides
    @Singleton
    fun provideCryptoRepository(coinApi: CoinmarketcapApi, serverMapper: CryptoEntityDataMapper, coinResponseMapper: CoinmarketResponseItemMapper): CryptoRepository {
        return CryptoDataRepository(coinApi, serverMapper, coinResponseMapper)
    }

}