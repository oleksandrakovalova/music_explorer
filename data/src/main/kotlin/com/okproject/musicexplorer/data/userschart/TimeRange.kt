package com.okproject.musicexplorer.data.userschart

internal enum class TimeRange {
    LONG_TERM,
    MEDIUM_TERM,
    SHORT_TERM;

    fun toQueryParam(): String = name.lowercase()
}