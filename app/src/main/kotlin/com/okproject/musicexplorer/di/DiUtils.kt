package com.okproject.musicexplorer.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.okproject.musicexplorer.MainActivity
import org.koin.androidx.compose.koinViewModel

@Composable
inline fun <reified T : ViewModel> koinActivityViewModel(): T =
    koinViewModel(
        viewModelStoreOwner = LocalContext.current as MainActivity
    )