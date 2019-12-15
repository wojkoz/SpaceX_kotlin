package com.example.spacex_kotlin.launchesFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.spacex_kotlin.R

class LaunchesFragment : Fragment() {

    companion object {
        fun newInstance() = LaunchesFragment()
    }

    private lateinit var viewModel: LaunchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.launches_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LaunchesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
