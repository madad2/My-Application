package dev.madad.testandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.madad.testandroid.model.models.config.UiConfig
import dev.madad.testandroid.model.repositories.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        getUiConfiguration()
    }

    private fun getUiConfiguration() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val uiConfig = repository.getUiConfig()
                _uiState.value = UiState.Success(uiConfig)
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Ошибка загрузки конфигурации: ${e.message}")
            }
        }
    }
}

sealed class UiState {
    object Loading : UiState()
    class Success(val uiConfiguration: UiConfig) : UiState()
    class Error(val error: String) : UiState()
}