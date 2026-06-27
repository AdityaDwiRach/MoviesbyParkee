package id.adr.mobile.moviesbyparkee.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.adr.mobile.moviesbyparkee.R
import id.adr.mobile.moviesbyparkee.databinding.FragmentHomeBinding
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.presentation.home.adapter.HomeBackdropAdapter
import id.adr.mobile.moviesbyparkee.presentation.home.adapter.HomeSummaryAdapter
import id.adr.mobile.moviesbyparkee.presentation.main.MainViewModel
import id.adr.mobile.moviesbyparkee.utils.Constants.ZERO
import id.adr.mobile.moviesbyparkee.utils.applyStatusBarPadding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    private val binding get() = _binding

    private val popularAdapter by lazy { HomeBackdropAdapter {
        onMovieItemClicked(it)
    } }
    private val topRatedAdapter by lazy { HomeSummaryAdapter {
        onMovieItemClicked(it)
    } }
    private val nowPlayingAdapter by lazy { HomeSummaryAdapter {
        onMovieItemClicked(it)
    } }

    private var errorDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupToolbar()
        observeUiState()
        setupListener()

        viewModel.getMovies(resources.configuration.locales[ZERO].toLanguageTag())
    }

    private fun setupToolbar() {
        binding?.toolbarHome?.apply {
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_favorite -> {
                        mainViewModel.navigateToFavorite()
                        true
                    }
                    else -> false
                }
            }
            applyStatusBarPadding()
        }
    }

    private fun setupRecyclerView() {
        binding?.apply {
            rvHomePopular.apply {
                adapter = popularAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
            rvHomeTopRated.apply {
                adapter = topRatedAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
            rvHomeNowPlaying.apply {
                adapter = nowPlayingAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    handleUiState(state)
                }
            }
        }
    }

    private fun handleUiState(state: HomeUiState) {
        binding?.apply {
            pgHome.isVisible = state.isLoading
            
            popularAdapter.submitList(state.popularMovies)
            topRatedAdapter.submitList(state.topRatedMovies)
            nowPlayingAdapter.submitList(state.nowPlayingMovies)
        }

        if (state.errorMessage != null) {
            showErrorDialog()
        } else {
            errorDialog?.dismiss()
        }
    }

    private fun setupListener() {

        binding?.let {
        }
    }

    private fun onMovieItemClicked(item: MovieItemModel) {
        mainViewModel.navigateToDetail(item)
    }

    private fun showErrorDialog() {
        if (errorDialog?.isShowing == true) return

        errorDialog = AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.error_title))
            .setPositiveButton(getString(R.string.retry)) { _, _ ->
                viewModel.getMovies(resources.configuration.locales[ZERO].toLanguageTag())
            }
            .setCancelable(false)
            .create()
        
        errorDialog?.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        errorDialog?.dismiss()
        errorDialog = null
        _binding = null
    }
}
