package com.pro2on.cryptocurrency.data.repository

import com.pro2on.cryptocurrency.domain.dto.CryptoItem
import com.pro2on.cryptocurrency.domain.repository.CryptoRepository
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by pro2on on 1/22/18.
 */
@Singleton
class CryptoDataDemoRepository @Inject constructor() : CryptoRepository {


    override fun get(start: Int): Observable<List<CryptoItem>> {

        Timber.d("try to return smth")

        return Observable.create( object : ObservableOnSubscribe<List<CryptoItem>> {

            override fun subscribe(e: ObservableEmitter<List<CryptoItem>>) {

                val items: MutableList<CryptoItem> = ArrayList()
                for (i in 0 .. 99) {
                    items.add(CryptoItem("BTC", "bitcoin", "BTC", i,
                            10_000F, 1F, 1F, 100000F,
                            1F, 1F, 1F, 12.01F,
                            10F, 10F))
                }

                Timber.d("heheh")
                e.onNext(items.toList())
                e.onComplete()


            }

        } )
    }


}