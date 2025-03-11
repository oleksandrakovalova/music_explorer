package com.okproject.musicexplorer.data.network.response.content

import com.okproject.musicexplorer.data.network.response.common.CopyrightJson
import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import com.okproject.musicexplorer.data.network.response.common.ImageJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("show")
data class ShowJson(
    @SerialName("available_markets")
    val availableMarkets: List<String>,
    val copyrights: List<CopyrightJson>,
    val description: String,
    @SerialName("html_description")
    val htmlDescription: String,
    val explicit: Boolean,
    @SerialName("external_urls")
    override val externalUrls: ExternalUrlJson,
    override val href: String,
    override val id: String,
    val images: List<ImageJson>,
    @SerialName("is_externally_hosted")
    val isExternallyHosted: Boolean,
    val languages: List<String>,
    @SerialName("media_type")
    val mediaType: String,
    override val name: String,
    val publisher: String,
    override val type: String,
    override val uri: String,
    @SerialName("total_episodes")
    val totalEpisodes: Int
): ContentJson
