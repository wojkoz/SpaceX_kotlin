package com.example.spacex_kotlin.missionsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex_kotlin.R
import com.example.spacex_kotlin.groupie.ItemGroupie
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.historical_events_fragment.*

class MissionsFragment : Fragment() {

    companion object {
        fun newInstance() = MissionsFragment()
    }

    private lateinit var viewModel: MissionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.missions_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MissionsViewModel::class.java)

        val listaTyches: MutableList<ItemGroupie> = mutableListOf(
            ItemGroupie("1", "asdd", "asdds")
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
