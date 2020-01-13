package com.example.spacex_kotlin.launchesFragment

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
import com.example.spacex_kotlin.repository.model.room.launch.Launch
import com.example.spacex_kotlin.utils.LoadingState
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.historical_events_fragment.*
import kotlinx.android.synthetic.main.item_groupie.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchesFragment : Fragment() {


    private val viewModel: LaunchesViewModel by viewModel()
    val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.launches_fragment, container, false)
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

        swipeToRefresh.setOnRefreshListener{

            viewModel.onRefresh()

            Toast.makeText(context, "Refreshed", Toast.LENGTH_SHORT).show()

            swipeToRefresh.isRefreshing = false
        }
    }

    private fun updateRecycler(items: List<Launch>){
        val recList = items.map { item -> ItemGroupie(item.launchName, item.launchDescription, item.launchId) }
        groupAdapter.clear()
        groupAdapter.add(Section(recList))

        groupAdapter.setOnItemClickListener { _, view ->
            val action = LaunchesFragmentDirections.actionLaunchesFragmentToLaunchDetailFragment(view.item_id.text.toString())
            view.findNavController().navigate(action)
        }
    }

}
