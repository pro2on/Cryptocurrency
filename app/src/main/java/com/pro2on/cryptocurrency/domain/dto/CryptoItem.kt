package com.pro2on.cryptocurrency.domain.dto



/**
 * This is just a clas for storing crypto item
 * Created by pro2on on 1/22/18.
 */
data class CryptoItem(
                      val id: String = "",
                      val name: String = "",
                      val symbol: String = "",
                      val rank: Int = 0,
                      val priceUsd: Float = 0f,
                      val priceBtc: Float = 0f,
                      val _24hVolumeUsd: Float = 0f,
                      val marketCapUsd: Float = 0f,
                      val availableSupply: Float = 0f,
                      val totalSupply: Float = 0f,
                      val maxSupply: Float = 0f,
                      val percentChange1h: Float = 0f,
                      val percentChange24h: Float = 0f,
                      val percentChange7d: Float = 0f,
                      val lastUpdated: Int = 0) {

}