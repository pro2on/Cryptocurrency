package com.pro2on.cryptocurrency.data.net

import com.pro2on.cryptocurrency.data.entity.CryptoEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by pro2on on 1/30/18.
 */
@Singleton
class CoinmarketResponseItemMapper @Inject constructor() {

    fun transform(ri: ResponseItem): CryptoEntity {

        val id = ri.id ?: ""
        val name = ri.name?: ""
        val symbol = ri.symbol ?: ""
        val rank = ri.rank?.toInt() ?: 0
        val priceUsd = ri.priceUsd?.toFloat() ?: 0F
        val priceBtc = ri.priceBtc?.toFloat() ?: 0F
        val _24hVolumeUsd = ri._24hVolumeUsd?.toFloat() ?: 0F
        val marketCapUsd = ri.marketCapUsd?.toFloat() ?: 0F
        val availableSupply = ri.availableSupply?.toFloat() ?: 0F
        val totalSupply = ri.totalSupply?.toFloat() ?: 0F
        val maxSupply = ri.maxSupply?.toFloat() ?: 0F
        val percentChange1h = ri.percentChange1h?.toFloat() ?: 0F
        val percentChange24h = ri.percentChange24h?.toFloat() ?: 0F
        val percentChange7d = ri.percentChange7d?.toFloat() ?: 0F
        val lastUpdated = ri.lastUpdated?.toInt() ?: 0


        return CryptoEntity(id, name, symbol, rank, priceUsd, priceBtc, _24hVolumeUsd, marketCapUsd,
                availableSupply, totalSupply, maxSupply, percentChange1h, percentChange24h,
                percentChange7d, lastUpdated)
    }

}