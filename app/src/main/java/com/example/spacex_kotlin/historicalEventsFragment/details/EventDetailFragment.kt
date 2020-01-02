package com.example.spacex_kotlin.historicalEventsFragment.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.spacex_kotlin.R

class EventDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            EventDetailFragment()
    }

    private lateinit var detailViewModel: EventDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.event_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        detailViewModel = ViewModelProviders.of(this).get(EventDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
