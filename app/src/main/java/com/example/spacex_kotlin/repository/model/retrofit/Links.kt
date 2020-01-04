package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "article_link")
    val articleLink: Any?,
    @Json(name = "flickr_images")
    val flickrImages: List<Any>,
    @Json(name = "mission_patch")
    val missionPatch: Any?,
    @Json(name = "mission_patch_small")
    val missionPatchSmall: Any?,
    @Json(name = "presskit")
    val presskit: Any?,
    @Json(name = "reddit_campaign")
    val redditCampaign: String,
    @Json(name = "reddit_launch")
    val redditLaunch: Any?,
    @Json(name = "reddit_media")
    val redditMedia: Any?,
    @Json(name = "reddit_recovery")
    val redditRecovery: Any?,
    @Json(name = "video_link")
    val videoLink: Any?,
    @Json(name = "wikipedia")
    val wikipedia: Any?,
    @Json(name = "youtube_id")
    val youtubeId: Any?
)