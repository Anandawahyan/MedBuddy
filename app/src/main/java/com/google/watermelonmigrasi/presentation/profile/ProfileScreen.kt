package com.google.watermelonmigrasi.presentation.profile

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.watermelonmigrasi.components.TopBar
import com.google.watermelonmigrasi.core.Constants.PROFILE_SCREEN
import com.google.watermelonmigrasi.presentation.profile.components.ProfileContent
import com.google.watermelonmigrasi.presentation.profile.components.RevokeAccess

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBar(
                title = PROFILE_SCREEN,
                signOut = {
                    viewModel.signOut()
                },
                revokeAccess = {
                    viewModel.revokeAccess()
                }
            )
        },
        content = { padding ->
            ProfileContent(
                padding = padding
            )
        },
        scaffoldState = scaffoldState
    )

    RevokeAccess(
        scaffoldState = scaffoldState,
        coroutineScope = coroutineScope,
        signOut = {
            viewModel.signOut()
        }
    )
}