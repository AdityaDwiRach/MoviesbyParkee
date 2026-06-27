package id.adr.mobile.moviesbyparkee.presentation.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    fun navigateToDetail(movie: MovieItemModel) {
        _uiState.update { it.copy(navigation = MainNavigation.ToDetail(movie)) }
    }

    fun navigateToFavorite() {
        _uiState.update { it.copy(navigation = MainNavigation.ToFavorite) }
    }

    fun navigateBack() {
        _uiState.update { it.copy(navigation = MainNavigation.Back) }
    }

    fun onNavigationConsumed() {
        _uiState.update { it.copy(navigation = null) }
    }
}
