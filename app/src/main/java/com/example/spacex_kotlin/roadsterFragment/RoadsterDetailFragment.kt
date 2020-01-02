package com.example.spacex_kotlin.roadsterFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.spacex_kotlin.R

class RoadsterDetailFragment : Fragment() {

    companion object {
        fun newInstance() = RoadsterDetailFragment()
    }

    private lateinit var detailViewModel: RoadsterDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.roadster_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        detailViewModel = ViewModelProviders.of(this).get(RoadsterDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
