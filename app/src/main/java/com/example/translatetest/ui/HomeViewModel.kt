package com.example.translatetest.ui

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.translatetest.model.Model
import com.example.translatetest.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository, application: Application) :
    AndroidViewModel(application) {
    private val _state = mutableStateOf(HomeViewState())
    val state: State<HomeViewState>
        get() = _state

    fun getTranslate(query: String, trans: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(
                query = repository.getTranslate(query, trans)
            )
        }
    }

    companion object {
        fun provideFactory(
            application: Application,
            repository: Repository
        ): ViewModelProvider.AndroidViewModelFactory {
            return object : ViewModelProvider.AndroidViewModelFactory(application) {
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                        return HomeViewModel(repository, application) as T
                    }
                    throw IllegalArgumentException("")
                }
            }
        }
    }
}

data class HomeViewState(
    val query: Model? = null
)
