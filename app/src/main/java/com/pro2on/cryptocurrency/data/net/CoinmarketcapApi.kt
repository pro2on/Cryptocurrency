package com.pro2on.cryptocurrency.data.net

import com.pro2on.cryptocurrency.data.entity.CryptoEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by pro2on on 1/30/18.
 */
interface CoinmarketcapApi {

    // get list of currencies
    @GET("/v1/ticker/")
    fun get(@Query("start") start: Int, @Query("limit") limit: Int): Observable<List<ResponseItem>>

    // get specific currency
    @GET("/v1/ticker/{id}/")
    fun getById(@Path("id") id: String): Observable<ResponseItem>

}