package id.adr.mobile.moviesbyparkee.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.adr.mobile.moviesbyparkee.domain.mapper.orEmpty
import id.adr.mobile.moviesbyparkee.domain.model.DetailReviewItem
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.domain.usecase.DeleteFavoriteUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.GetMovieReviewsUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.InsertFavoriteUseCase
import id.adr.mobile.moviesbyparkee.domain.usecase.IsFavoriteUseCase
import id.adr.mobile.moviesbyparkee.utils.Constants.ONE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieReviewsUseCase: GetMovieReviewsUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    private val insertFavoriteUseCase: InsertFavoriteUseCase,
    private val isFavoriteUseCase: IsFavoriteUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    var movieArgs: MovieItemModel? = null

    fun getMovieReview(languageTag: String) {
        _uiState.update { it.copy(isLoading = true) }
        checkFavoriteStatus()
        viewModelScope.launch {
            getMovieReviewsUseCase.invoke(movieArgs?.id ?: ONE, ONE, languageTag).catch { e ->
                _uiState.update { it.copy(isLoading = false, errorMessage = e.message) }
            }.collect { model ->
                _uiState.update { it.copy(
                    movieDetail = DetailReviewItem(movieArgs.orEmpty(), model.results),
                    isLoading = false
                ) }
            }
        }
    }

    private fun checkFavoriteStatus() {
        movieArgs?.let {
            val isFav = isFavoriteUseCase(it.id)
            _uiState.update { state -> state.copy(isFavorite = isFav) }
        }
    }

    fun toggleFavorite() {
        movieArgs?.let { movie ->
            viewModelScope.launch {
                val currentFav = _uiState.value.isFavorite
                if (currentFav) {
                    deleteFavoriteUseCase(movie)
                } else {
                    insertFavoriteUseCase(movie)
                }
                _uiState.update { it.copy(isFavorite = !currentFav) }
            }
        }
    }
}
