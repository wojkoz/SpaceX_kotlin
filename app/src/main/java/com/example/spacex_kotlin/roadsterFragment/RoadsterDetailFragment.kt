package com.example.spacex_kotlin.roadsterFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.spacex_kotlin.R
import kotlinx.android.synthetic.main.roadster_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoadsterDetailFragment : Fragment() {

    private val viewModel: RoadsterDetailViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.roadster_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.data.observe(this, Observer {
            roadster_days_in_space.text = it.daysInSpace.toString()
            roadster_desc.text = it.details
            roadster_distance_from_earth.text = it.distanceFromEarth.toString()
            roadster_distance_from_mars.text = it.distanceFromMars.toString()
            roadster_speed.text = it.speed.toString()
            roadster_start_mass.text = it.mass
            roadster_wikipedia_links.text = it.wikipediaLink
            roadster_space_time_send.text = it.launch_date
        })
    }

}
