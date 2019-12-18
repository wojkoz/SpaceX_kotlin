package com.example.spacex_kotlin.rocketsFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.spacex_kotlin.R
import com.example.spacex_kotlin.groupie.ItemGroupie
import com.example.spacex_kotlin.repository.model.Rocket
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.historical_events_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RocketsFragment : Fragment() {



    private val rocketsViewModel by viewModel<RocketsViewModel>()
    lateinit var listaTych: List<Rocket>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rockets_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rocketsViewModel.data.observe(this, Observer {
            listaTych = it;
        })

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
        val section = Section(listaTych as MutableCollection<out Group>)
        groupAdapter.add(section)

        // TODO: Use the ViewModel
    }

}
