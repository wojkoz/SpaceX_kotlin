package com.example.spacex_kotlin.repository.model.retrofit


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksX(
    @Json(name = "article_link")
    val articleLink: String?,
    @Json(name = "presskit")
    val presskit: Any?,
    @Json(name = "reddit_campaign")
    val redditCampaign: Any?,
    @Json(name = "reddit_launch")
    val redditLaunch: Any?,
    @Json(name = "reddit_media")
    val redditMedia: Any?,
    @Json(name = "reddit_recovery")
    val redditRecovery: Any?,
    @Json(name = "video_link")
    val videoLink: String?,
    @Json(name = "wikipedia")
    val wikipedia: String?,
    @Json(name = "youtube_id")
    val youtubeId: String?
)