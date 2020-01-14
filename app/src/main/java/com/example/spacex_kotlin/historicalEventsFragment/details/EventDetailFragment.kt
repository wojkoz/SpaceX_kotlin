package com.example.spacex_kotlin.historicalEventsFragment.details

import android.os.Bundle
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.spacex_kotlin.R
import kotlinx.android.synthetic.main.event_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class EventDetailFragment : Fragment() {

    private lateinit var id: String
    private val viewModel: EventDetailViewModel by viewModel{ parametersOf(id) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.event_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        id = arguments!!.getString("event_id").orEmpty()

        viewModel.data.observe(this, Observer {
            event_title.text = it.eventTitle
            event_desc.text = it.eventDescription
            event_date. text = it.eventDate
            event_spacex_article.text = it.eventSpacexLink
            event_wikipedia.text = it.eventWikipediaLink

            Linkify.addLinks(event_wikipedia, Linkify.ALL)
            Linkify.addLinks(event_spacex_article, Linkify.ALL)
        })
    }

}
