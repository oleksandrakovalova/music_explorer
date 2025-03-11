package com.okproject.musicexplorer.data.network.response.content

import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import com.okproject.musicexplorer.data.network.response.common.ImageJson
import com.okproject.musicexplorer.data.network.response.common.RestrictionJson
import com.okproject.musicexplorer.data.network.response.episode.ResumePointJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("episode")
data class EpisodeJson(
    val description: String,
    @SerialName("html_description")
    val htmlDescription: String,
    @SerialName("duration_ms")
    val durationMs: String,
    val explicit: Boolean,
    @SerialName("external_urls")
    override val externalUrls: ExternalUrlJson,
    override val href: String,
    override val id: String,
    val images: List<ImageJson>,
    @SerialName("is_externally_hosted")
    val isExternallyHosted: Boolean,
    @SerialName("is_playable")
    val isPlayable: Boolean,
    val languages: List<String>,
    override val name: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("release_date_precision")
    val releaseDatePrecision: String,
    @SerialName("resume_point")
    val resumePoint: ResumePointJson,
    override val type: String,
    override val uri: String,
    val restrictions: RestrictionJson? = null,
    val show: ShowJson
): ContentJson
