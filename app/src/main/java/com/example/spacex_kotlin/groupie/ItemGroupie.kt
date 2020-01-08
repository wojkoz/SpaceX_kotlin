package com.example.spacex_kotlin.groupie

import com.example.spacex_kotlin.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_groupie.*
import com.example.spacex_kotlin.utils.shortDesc


class ItemGroupie(private val header: String, private val content: String, val item_id: String) : Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.header.text = header
        viewHolder.content.text = shortDesc(content)
        viewHolder.item_id.text = item_id
    }

    override fun getLayout() = R.layout.item_groupie
}