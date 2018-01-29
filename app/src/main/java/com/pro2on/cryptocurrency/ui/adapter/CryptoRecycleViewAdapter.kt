package com.pro2on.cryptocurrency.ui.adapter

import android.content.res.Resources
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pro2on.cryptocurrency.R
import com.pro2on.cryptocurrency.domain.dto.CryptoItem
import kotlinx.android.synthetic.main.crypto_item.view.*

/**
 * Created by pro2on on 1/26/18.
 */
class CryptoRecycleViewAdapter(var resources: Resources, private val items: MutableList<CryptoItem>) : RecyclerView.Adapter<CryptoRecycleViewAdapter.CryptoViewHolder>() {

    // Used layout for recycleView item
    private val LAYOUT: Int = R.layout.crypto_item


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CryptoViewHolder {
        return CryptoViewHolder(LayoutInflater.from(parent?.context)
                .inflate(LAYOUT, parent, false))
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: CryptoViewHolder?, position: Int) {
        val item: CryptoItem = items[position]
        holder?.bind(item, resources)
    }


    class CryptoViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: CryptoItem, resources: Resources) {

            itemView.symbol.text = item.symbol
            itemView.name.text = item.name
            itemView.money.text = item.priceUsd.toString() + "$"
            itemView.hours.text = item.percentChange24h.toString() + "%"
            itemView.days.text = item.percentChange7d.toString() + "%"

            itemView.hours.setTextColor(getTextColor(item.percentChange24h, resources))
            itemView.days.setTextColor(getTextColor(item.percentChange7d, resources))
        }

        private fun getTextColor(value: Float, resources: Resources): Int {
            return if (value > 0.0) {
                resources.getColor(R.color.green)
            } else {
                resources.getColor(R.color.red)
            }
        }
    }


    fun swapItems(nitems: List<CryptoItem>) {
        items.clear()
        items.addAll(nitems)
        notifyDataSetChanged()
    }
}