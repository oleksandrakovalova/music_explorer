package com.okproject.musicexplorer.mapper

import com.okproject.musicexplorer.domain.model.Artist
import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist
import com.okproject.musicexplorer.domain.model.Track
import com.okproject.musicexplorer.domain.userschart.ChartPeriod
import com.okproject.musicexplorer.ui.component.ImageItem

fun Artist.toImageItemData(): ImageItem =
    ImageItem(
        id = this.id,
        imageUrl = this.images.firstOrNull()?.url ?: "",
        title = this.name
    )

fun Track.toImageItemData(): ImageItem =
    ImageItem(
        id = this.id,
        imageUrl = this.image,
        title = this.name,
        subtitle = this.artists.joinToString { it }
    )

fun ChartPeriod.toChipId(): String = this.name.lowercase()

fun String.toChartPeriod(): ChartPeriod =
    ChartPeriod.entries.find { period ->
        period.name == this.uppercase()
    } ?: ChartPeriod.YEAR