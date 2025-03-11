package com.okproject.musicexplorer.data.network.response.episode

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResumePointJson(
    @SerialName("fully_played")
    val fullyPlayed: Boolean,
    @SerialName("resume_position_ms")
    val resumePositionMs: Long
)
