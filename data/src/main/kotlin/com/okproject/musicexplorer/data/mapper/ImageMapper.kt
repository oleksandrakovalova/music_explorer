package com.okproject.musicexplorer.data.mapper

import com.okproject.musicexplorer.data.network.response.common.ImageJson
import com.okproject.musicexplorer.domain.model.Image
import timber.log.Timber

// TODO remove temporary logs
private const val MAPPER_TAG = "ImageMapper"
fun ImageJson.toImage(): Image {
    Timber.tag(MAPPER_TAG).d(this.toString())
    return Image(
        url = this.url,
        height = this.height,
        width = this.width
    )
}


fun List<ImageJson>.toImageList(): List<Image> =
    this.map { it.toImage() }