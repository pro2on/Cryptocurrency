package com.pro2on.cryptocurrency.domain.repository

/**
 * Created by pro2on on 1/22/18.
 */
interface CryptoRepository {

    /* get cryptos */
    fun get(start: Int, limit: Int)

}