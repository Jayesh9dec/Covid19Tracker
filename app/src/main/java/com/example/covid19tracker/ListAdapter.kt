package com.example.covid19tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter(val statelist: List<StatewiseItem>): RecyclerView.Adapter<ListAdapter.ItemHolder>() {

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(statewiseItem: StatewiseItem) {
            itemView.stateTV.text=statewiseItem.state
            itemView.activetv.text=statewiseItem.active
            itemView.confirmedtv.text=statewiseItem.confirmed
            itemView.deathstv.text=statewiseItem.deaths
            itemView.curedtv.text=statewiseItem.recovered
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.onBind(statelist[position])
    }

    override fun getItemCount(): Int =statelist.size
}