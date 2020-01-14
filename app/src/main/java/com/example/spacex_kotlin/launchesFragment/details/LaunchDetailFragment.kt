package com.example.spacex_kotlin.launchesFragment.details

import android.os.Bundle
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.spacex_kotlin.R
import com.example.spacex_kotlin.utils.getVideoId
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener
import kotlinx.android.synthetic.main.launch_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class LaunchDetailFragment : Fragment() {

    private lateinit var id: String
    private val viewModel: LaunchDetailViewModel by viewModel { parametersOf(id) }
    private var video: String = ""

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

            video = getVideoId(it.launchVideoLink!!)

        })

        lifecycle.addObserver(youtube_player_view)
        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = video
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })


    }

}
