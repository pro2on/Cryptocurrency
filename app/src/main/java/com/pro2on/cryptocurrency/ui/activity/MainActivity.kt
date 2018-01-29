package com.pro2on.cryptocurrency.ui.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.pro2on.cryptocurrency.R
import com.pro2on.cryptocurrency.application.CryptoApp
import com.pro2on.cryptocurrency.domain.dto.CryptoItem
import com.pro2on.cryptocurrency.domain.interactor.CryptoListInteractor
import com.pro2on.cryptocurrency.mvp.presenter.MainPresenter
import com.pro2on.cryptocurrency.mvp.view.MainView
import com.pro2on.cryptocurrency.ui.adapter.CryptoRecycleViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {


    // Extension property for the app
    val Activity.app: CryptoApp
        get() = application as CryptoApp


    @Inject
    lateinit var cryptoListInteractor: CryptoListInteractor

    @InjectPresenter
    lateinit var mainPresenter : MainPresenter


    @ProvidePresenter
    fun provideMainPresenter() = MainPresenter(cryptoListInteractor)


    lateinit var cryptoAdapter: CryptoRecycleViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        app.component.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        cryptoAdapter = CryptoRecycleViewAdapter(resources, ArrayList())

        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = cryptoAdapter

    }


    // Just show simple toast
    override fun showToast() {
        Toast.makeText(this, R.string.hello_toast, Toast.LENGTH_SHORT).show()
        Timber.d("Toast is showed")
    }


    override fun setItems(items: List<CryptoItem>) {
        cryptoAdapter.swapItems(items)
        Timber.d("items setup")
    }


}
