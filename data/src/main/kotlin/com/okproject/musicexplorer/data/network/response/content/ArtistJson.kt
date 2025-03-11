package com.okproject.musicexplorer.data.network.response.content

import com.okproject.musicexplorer.data.network.response.common.AmountJson
import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import com.okproject.musicexplorer.data.network.response.common.ImageJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("artist")
data class ArtistJson(
    @SerialName("external_urls")
    override val externalUrls: ExternalUrlJson,
    val followers: AmountJson,
    val genres: List<String>,
    override val href: String,
    override val id: String,
    val images: List<ImageJson>,
    override val name: String,
    val popularity: Int,
    override val type: String,
    override val uri: String
): ContentJson
