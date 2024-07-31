package dev.madad.testandroid.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.madad.testandroid.model.models.user.User
import dev.madad.testandroid.model.repositories.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserInfoViewModel(private val repository: Repository) : ViewModel() {
    private val _userInfo = MutableStateFlow<User?>(null)
    val userInfo: StateFlow<User?> = _userInfo

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchUserInfo(url: String) {
        viewModelScope.launch {
            try {
                val userResponse = repository.getUserInfo(url)
                if (!userResponse.error.isError) {
                    _userInfo.value = userResponse.data.user
                } else {
                    _error.value = userResponse.error.description
                }
            } catch (e: Exception) {
                _error.value = "Ошибка загрузки данных"
            }
        }
    }
}