package dev.madad.testandroid

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<MainState>(MainState.Loading)
    val uiState: StateFlow<MainState> = _uiState

    private suspend fun getConfiguration() {

    }
}

sealed class MainState {
    object Loading : MainState()
    class Success(val configuration: String) : MainState()
    class Error(val error: String) : MainState()
}