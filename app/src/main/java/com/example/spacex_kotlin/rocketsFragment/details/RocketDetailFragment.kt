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
        // TODO: Use the ViewModel

        viewModel.data.observe(this, Observer {
            Toast.makeText(context, it.rocketName, Toast.LENGTH_SHORT).show()
            texxt.text = it.description
        })



    }

}
