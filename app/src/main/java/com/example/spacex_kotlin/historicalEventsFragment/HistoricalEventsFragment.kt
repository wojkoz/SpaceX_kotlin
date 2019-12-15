package com.example.spacex_kotlin.historicalEventsFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.spacex_kotlin.R

class HistoricalEventsFragment : Fragment() {

    companion object {
        fun newInstance() = HistoricalEventsFragment()
    }

    private lateinit var viewModel: HistoricalEventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.historical_events_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HistoricalEventsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
