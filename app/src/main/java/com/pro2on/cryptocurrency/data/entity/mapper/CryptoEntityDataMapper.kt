package com.pro2on.cryptocurrency.data.entity.mapper

import com.pro2on.cryptocurrency.data.entity.CryptoEntity
import com.pro2on.cryptocurrency.domain.dto.CryptoItem
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by pro2on on 1/22/18.
 */
@Singleton
class CryptoEntityDataMapper @Inject constructor() {

    fun transform(cryptoEntity: CryptoEntity) = CryptoItem(cryptoEntity.id,
            cryptoEntity.name,
            cryptoEntity.symbol,
            cryptoEntity.rank,
            cryptoEntity.priceUsd,
            cryptoEntity.priceBtc,
            cryptoEntity._24hVolumeUsd,
            cryptoEntity.marketCapUsd,
            cryptoEntity.availableSupply,
            cryptoEntity.totalSupply,
            cryptoEntity.maxSupply,
            cryptoEntity.percentChange1h,
            cryptoEntity.percentChange24h,
            cryptoEntity.percentChange7d,
            cryptoEntity.lastUpdated)

}