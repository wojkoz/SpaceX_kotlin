package com.example.spacex_kotlin.historicalEventsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex_kotlin.utils.LoadingState
import com.example.spacex_kotlin.R
import com.example.spacex_kotlin.groupie.ItemGroupie
import com.example.spacex_kotlin.repository.model.room.events.HistoricalEvent
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.historical_events_fragment.*
import kotlinx.android.synthetic.main.item_groupie.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HistoricalEventsFragment : Fragment() {

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private  val viewModel: HistoricalEventsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.historical_events_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel.data.observe(this, Observer {
            updateRecycler(it)
        })

        viewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.RUNNING -> {
                    Toast.makeText(context,"Loading data", Toast.LENGTH_SHORT).show()
                }
                LoadingState.Status.SUCCESS -> {
                    Toast.makeText(context,"Data has been updated", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(context, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        })


        recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL ,false)
            adapter = groupAdapter
        }


        val section = Section()
        groupAdapter.add(section)
    }

    private fun updateRecycler(items: List<HistoricalEvent>){
        val recList = items.map { item -> ItemGroupie(item.eventTitle!!, item.eventDescription!!, item.eventId) }
        groupAdapter.clear()
        groupAdapter.add(Section(recList))

        groupAdapter.setOnItemClickListener { _, view ->
            val action = HistoricalEventsFragmentDirections.actionHistoricalEventsFragmentToEventDetailFragment(view.item_id.text.toString())
            view.findNavController().navigate(action)
        }
    }

}
