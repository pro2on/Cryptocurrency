package com.pro2on.cryptocurrency.mvp.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.pro2on.cryptocurrency.domain.dto.CryptoItem

/**
 * Created by pro2on on 1/23/18.
 */
interface MainView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showToast()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setItems(items: List<CryptoItem>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun toggleProgress(isShown: Boolean)

}