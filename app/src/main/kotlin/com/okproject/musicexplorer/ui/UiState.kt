package com.okproject.musicexplorer.ui

// TODO implement loading and error states on screens
sealed interface UiState<T>

data class Loading<T>(
    val message: String = ""
): UiState<T>

data class Loaded<T>(
    val data: T
): UiState<T>

data class ErrorMessage<T>(
    val message: String = ""
): UiState<T>