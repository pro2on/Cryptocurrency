package com.pro2on.cryptocurrency.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.pro2on.cryptocurrency.domain.interactor.CryptoListInteractor
import com.pro2on.cryptocurrency.mvp.view.MainView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by pro2on on 1/23/18.
 */
@InjectViewState
class MainPresenter(val interactor: CryptoListInteractor) : MvpPresenter<MainView>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    // When
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        initialLoading()
    }

    private fun initialLoading() {

        Timber.d("initial loading begin")

        unsubscribeOnDestroy(

                interactor.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            items -> viewState.setItems(items)
                            Timber.d("got items from interactor")
                        },
                        {
                            e -> viewState.showToast()
                            Timber.e(e.message)
                        }
                )
        )
    }

    private fun unsubscribeOnDestroy(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }


    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}