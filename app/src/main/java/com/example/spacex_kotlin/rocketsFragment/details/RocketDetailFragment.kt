package com.example.spacex_kotlin.rocketsFragment.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.spacex_kotlin.R
import kotlinx.android.synthetic.main.rocket_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RocketDetailFragment : Fragment() {

    private lateinit var id: String
    private val viewModel: RocketDetailViewModel by viewModel{ parametersOf(id)}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rocket_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        id = arguments!!.getString("rocket_id").orEmpty()


        //TODO: poprawic wyswietlanie
        viewModel.data.observe(this, Observer {
            Toast.makeText(context, it.rocketName, Toast.LENGTH_SHORT).show()
            rocket_name.text = it.rocketName
            rocket_type.text = it.rocketType
            rocket_first_stage.text = "First stage"
            rocket_second_stage.text = "Second Stage"
            rocket_mass.text = it.rocketMass
            rocket_diameter.text = it.rocketDiameter
            rocket_height.text = it.rocketHeight
            rocket_start_cost.text = it.rocketCostPerLaunch
            rocket_first_flight.text = it.rocketFirstFlight
            rocket_desc.text = it.rocketDescription

        })



    }

}
