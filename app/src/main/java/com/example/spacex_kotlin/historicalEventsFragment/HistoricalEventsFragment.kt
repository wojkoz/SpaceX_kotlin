package com.example.spacex_kotlin.historicalEventsFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.spacex_kotlin.R
import com.example.spacex_kotlin.groupie.ItemGroupie
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.historical_events_fragment.*


class HistoricalEventsFragment : Fragment() {

    companion object {
        fun newInstance() = HistoricalEventsFragment()
    }

    private lateinit var viewModel: HistoricalEventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.historical_events_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HistoricalEventsViewModel::class.java)

        val listaTyches: MutableList<ItemGroupie> = mutableListOf(
            ItemGroupie("1", "asdd"),
            ItemGroupie("2", "asdd")
            ,
            ItemGroupie("3", "asdd"),
            ItemGroupie("4", "asdd"),
            ItemGroupie("5", "asdd"),
            ItemGroupie("6", "asdd")
        )
        val groupAdapter = GroupAdapter<GroupieViewHolder>()


        recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL ,false)
            adapter = groupAdapter
        }
        val section = Section(listaTyches)
        groupAdapter.add(section)

        // TODO: Use the ViewModel
    }

}
