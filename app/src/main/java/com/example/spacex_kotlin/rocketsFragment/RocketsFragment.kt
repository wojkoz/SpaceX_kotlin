package com.example.spacex_kotlin.rocketsFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.spacex_kotlin.R

class RocketsFragment : Fragment() {

    companion object {
        fun newInstance() = RocketsFragment()
    }

    private lateinit var viewModel: RocketsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rockets_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RocketsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}