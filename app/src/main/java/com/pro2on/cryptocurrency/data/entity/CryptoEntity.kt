package com.pro2on.cryptocurrency.data.entity


/**
 * Created by pro2on on 1/22/18.
 */
data class CryptoEntity(val id: String,
                        val name: String,
                        val symbol: String,
                        val rank: Int,
                        val priceUsd: Float,
                        val priceBtc: Float,
                        val _24hVolumeUsd: Float,
                        val marketCapUsd: Float,
                        val availableSupply: Float,
                        val totalSupply: Float,
                        val maxSupply: Float,
                        val percentChange1h: Float,
                        val percentChange24h: Float,
                        val percentChange7d: Float,
                        val lastUpdated: Int) {
}