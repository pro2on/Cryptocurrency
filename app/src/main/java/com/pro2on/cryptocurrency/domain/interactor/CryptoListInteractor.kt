package com.pro2on.cryptocurrency.domain.interactor

import com.pro2on.cryptocurrency.domain.dto.CryptoItem
import com.pro2on.cryptocurrency.domain.repository.CryptoRepository
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by pro2on on 1/23/18.
 */
class CryptoListInteractor @Inject constructor(private var cryptoRepository: CryptoRepository) {


    var currentPage = 0


    fun get(): Observable<List<CryptoItem>> {
        Timber.d("I hear you")
        return cryptoRepository.get(0)
    }


    // When we need to download initial
    fun getInitial() {
        Timber.d("get initial was called")
    }
}