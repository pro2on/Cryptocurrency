package com.pro2on.cryptocurrency.domain.repository

import com.pro2on.cryptocurrency.domain.dto.CryptoItem
import io.reactivex.Observable

/**
 * Created by pro2on on 1/22/18.
 */
interface CryptoRepository {

    /* get cryptos */
    fun get(start: Int): Observable<List<CryptoItem>>

}