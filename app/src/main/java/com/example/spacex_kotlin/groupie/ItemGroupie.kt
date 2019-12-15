package com.example.spacex_kotlin.groupie

import com.example.spacex_kotlin.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_groupie.*


class ItemGroupie(private val header: String, private val content: String) : Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.header.text = header
        viewHolder.content.text = content
    }

    override fun getLayout() = R.layout.item_groupie
}