package com.example.spacex_kotlin.launchesFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.spacex_kotlin.R

class LaunchDetailFragment : Fragment() {

    companion object {
        fun newInstance() = LaunchDetailFragment()
    }

    private lateinit var detailViewModel: LaunchDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.launch_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        detailViewModel = ViewModelProviders.of(this).get(LaunchDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
