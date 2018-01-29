package com.pro2on.cryptocurrency.data.entity.mapper

import com.pro2on.cryptocurrency.data.entity.CryptoEntity
import com.pro2on.cryptocurrency.domain.dto.CryptoItem
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/*
    {
        "id": "bitcoin",
        "name": "Bitcoin",
        "symbol": "BTC",
        "rank": "1",
        "price_usd": "10715.3",
        "price_btc": "1.0",
        "24h_volume_usd": "9382550000.0",
        "market_cap_usd": "180224509639",
        "available_supply": "16819362.0",
        "total_supply": "16819362.0",
        "max_supply": "21000000.0",
        "percent_change_1h": "0.99",
        "percent_change_24h": "-7.55",
        "percent_change_7d": "-24.38",
        "last_updated": "1516639761"
    }

 */

class CryptoEntityDataMapperTest {


    val cryptoEntity = CryptoEntity("bitcoin", "Bitcoin", "BTC", 1,
            10715.3f, 1.0f, 9382550000.0f, 180224509639f,
            16819362.0f, 16819362.0f, 21000000.0f,
            0.99f, -7.55f, -24.38f, 1516639761)

    val cryptoEntityDataMapper = CryptoEntityDataMapper()

    lateinit var cryptoItem : CryptoItem


    @Before
    fun setUp() {
        cryptoItem = cryptoEntityDataMapper.transform(cryptoEntity)
    }

    @Test
    fun transform_testId() {
        assertEquals(cryptoEntity.id, cryptoItem.id)
    }

    @Test
    fun transform_testName() {
        assertEquals(cryptoEntity.name, cryptoItem.name)
    }

    @Test
    fun transform_testSymbol() {
        assertEquals(cryptoEntity.symbol, cryptoItem.symbol)
    }

    @Test
    fun transform_testRank() {
        assertEquals(cryptoEntity.rank, cryptoItem.rank)
}
    @Test
    fun transform_testPriceUsd() {
        assertEquals(cryptoEntity.priceUsd, cryptoItem.priceUsd)
    }

    @Test
    fun transform_testPriceBtc() {
        assertEquals(cryptoEntity.priceBtc, cryptoItem.priceBtc)
    }

    @Test
    fun transform_test24USD() {
        assertEquals(cryptoEntity._24hVolumeUsd, cryptoItem._24hVolumeUsd)
    }

    @Test
    fun transform_testMarketCupUsd() {
        assertEquals(cryptoEntity.marketCapUsd, cryptoItem.marketCapUsd)
    }

    @Test
    fun transform_testAvailableSupply() {
        assertEquals(cryptoEntity.availableSupply, cryptoItem.availableSupply)
    }

    @Test
    fun transform_testTotalSupply() {
        assertEquals(cryptoEntity.totalSupply, cryptoItem.totalSupply)
    }

    @Test
    fun transform_testMaxSupply() {
        assertEquals(cryptoEntity.maxSupply, cryptoItem.maxSupply)
    }
    @Test
    fun transform_testPercent1h() {
        assertEquals(cryptoEntity.percentChange1h, cryptoItem.percentChange1h)
    }
    @Test
    fun transform_testPercent24h() {
        assertEquals(cryptoEntity.percentChange24h, cryptoItem.percentChange24h)
    }

    @Test
    fun transform_testPercent7d() {
        assertEquals(cryptoEntity.percentChange7d, cryptoItem.percentChange7d)
    }

    @Test
    fun transform_testLastupdate() {
        assertEquals(cryptoEntity.lastUpdated, cryptoItem.lastUpdated)
    }

}