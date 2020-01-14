package com.example.spacex_kotlin.groupie

import com.example.spacex_kotlin.R
import com.example.spacex_kotlin.utils.makeShortDesc
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_groupie.*


class ItemGroupie(private val header: String, private val content: String, val item_id: String) : Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.header.text = header
        viewHolder.content.text = makeShortDesc(content)
        viewHolder.item_id.text = item_id
    }

    override fun getLayout() = R.layout.item_groupie
}