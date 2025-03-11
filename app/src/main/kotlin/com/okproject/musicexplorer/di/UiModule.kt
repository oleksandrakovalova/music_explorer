package com.okproject.musicexplorer.di

import com.okproject.musicexplorer.auth.AuthorizationViewModel
import com.okproject.musicexplorer.home.HomeViewModel
import com.okproject.musicexplorer.main.CurrentlyPlayingViewModel
import com.okproject.musicexplorer.search.SearchViewModel
import com.okproject.musicexplorer.userschart.TopArtistsViewModel
import com.okproject.musicexplorer.userschart.TopTracksViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::AuthorizationViewModel)
    viewModelOf(::TopTracksViewModel)
    viewModelOf(::TopArtistsViewModel)
    viewModelOf(::CurrentlyPlayingViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
}