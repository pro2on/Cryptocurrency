package com.pro2on.cryptocurrency.data.repository

import com.pro2on.cryptocurrency.data.entity.CryptoEntity
import com.pro2on.cryptocurrency.data.entity.mapper.CryptoEntityDataMapper
import com.pro2on.cryptocurrency.data.net.CoinmarketResponseItemMapper
import com.pro2on.cryptocurrency.data.net.CoinmarketcapApi
import com.pro2on.cryptocurrency.data.net.ResponseItem
import com.pro2on.cryptocurrency.domain.dto.CryptoItem
import com.pro2on.cryptocurrency.domain.repository.CryptoRepository
import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by pro2on on 1/30/18.
 */
@Singleton
class CryptoDataRepository @Inject constructor(val coinApi: CoinmarketcapApi,
                                               val serverMapper: CryptoEntityDataMapper,
                                               val coinResponseMapper:CoinmarketResponseItemMapper): CryptoRepository {


    val LIMIT = 100

    override fun get(start: Int): Observable<List<CryptoItem>> {
       return coinApi.get(start, LIMIT)
               .map (object : Function<List<ResponseItem>, List<CryptoEntity>> {
                   override fun apply(t: List<ResponseItem>): List<CryptoEntity> {

                       val result = ArrayList<CryptoEntity>()

                       for (ri in t) {
                           result.add(coinResponseMapper.transform(ri))
                       }

                       return  result

                   }

               })
               .map ( object : Function<List<CryptoEntity>, List<CryptoItem>> {
                   override fun apply(t: List<CryptoEntity>): List<CryptoItem> {

                       val result: MutableList<CryptoItem> = ArrayList()

                       for (cr in t) {
                           var ci = serverMapper.transform(cr)
                           result.add(ci)
                       }

                       return result
                   }
               })
    }

}