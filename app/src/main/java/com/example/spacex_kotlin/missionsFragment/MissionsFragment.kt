package com.example.spacex_kotlin.missionsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex_kotlin.R
import com.example.spacex_kotlin.groupie.ItemGroupie
import com.example.spacex_kotlin.repository.model.room.mission.Mission
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.historical_events_fragment.*
import kotlinx.android.synthetic.main.item_groupie.view.*
import kotlinx.android.synthetic.main.mission_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MissionsFragment : Fragment() {

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    private val viewModel: MissionsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.missions_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel.data.observe(this, Observer {
            updateRecycler(it)
        })


        recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL ,false)
            adapter = groupAdapter
        }
        val section = Section()
        groupAdapter.add(section)
        swipeToRefresh.setOnRefreshListener{

            viewModel.onRefresh()

            Toast.makeText(context, "Refreshed", Toast.LENGTH_SHORT).show()

            swipeToRefresh.isRefreshing = false
        }
    }

    private fun updateRecycler(items: List<Mission>){
        val recList = items.map { item -> ItemGroupie(item.missionTitle, item.missionDetails, item.missionId) }
        groupAdapter.clear()
        groupAdapter.add(Section(recList))

        groupAdapter.setOnItemClickListener { _, view ->
            val action = MissionsFragmentDirections.actionMissionsFragmentToMissionDetailFragment(view.item_id.text.toString())
            view.findNavController().navigate(action)
        }
    }

}
