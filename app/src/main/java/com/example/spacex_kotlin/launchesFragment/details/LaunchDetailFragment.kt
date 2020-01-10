package com.example.spacex_kotlin.launchesFragment.details

import android.os.Bundle
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.spacex_kotlin.R
import kotlinx.android.synthetic.main.launch_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class LaunchDetailFragment : Fragment() {

    private lateinit var id: String
    private val viewModel: LaunchDetailViewModel by viewModel { parametersOf(id) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.launch_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        id = arguments!!.getString("launch_id").orEmpty()

        viewModel.data.observe(this, Observer {
            launch_date.text = it.launchStartDate
            launch_desc.text = it.launchDescription
            launch_number.text = it.launchId
            launch_rocket.text = it.launchRocketName
            launch_title.text = it.launchName
            launch_video_link.text = it.launchVideoLink

            Linkify.addLinks(launch_video_link, Linkify.ALL)
        })
    }

}
