package com.example.spacex_kotlin.missionsFragment.details

import android.os.Bundle
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.spacex_kotlin.R
import kotlinx.android.synthetic.main.mission_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MissionDetailFragment : Fragment() {

    private lateinit var id: String

    private val viewModel: MissionDetailViewModel by viewModel{ parametersOf(id) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mission_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        id = arguments!!.getString("mission_id").orEmpty()

        viewModel.data.observe(this, Observer {
            mission_desc.text = it.missionDetails
            mission_payload.text = it.missionPayload
            mission_title.text = it.missionTitle
            mission_www.text = it.missionWebsite
            mission_wikipedia.text = it.missionWikipedia
            mission_producents.text = it.missionProducent

            Linkify.addLinks(mission_wikipedia, Linkify.ALL)
            Linkify.addLinks(mission_www, Linkify.ALL)
        })

    }

}
