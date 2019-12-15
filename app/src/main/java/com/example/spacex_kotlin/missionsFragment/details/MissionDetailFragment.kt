package com.example.spacex_kotlin.missionsFragment.details

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.spacex_kotlin.R

class MissionDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            MissionDetailFragment()
    }

    private lateinit var detailViewModel: MissionDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mission_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        detailViewModel = ViewModelProviders.of(this).get(MissionDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
