package id.adr.mobile.moviesbyparkee.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
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
import id.adr.mobile.moviesbyparkee.databinding.FragmentFavoriteBinding
import id.adr.mobile.moviesbyparkee.presentation.favorite.adapter.FavoriteAdapter
import id.adr.mobile.moviesbyparkee.presentation.main.MainViewModel
import id.adr.mobile.moviesbyparkee.utils.applyStatusBarPadding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private var _binding: FragmentFavoriteBinding? = null
    private val viewModel: FavoriteViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    private val binding get() = _binding

    private val favoriteAdapter by lazy {
        FavoriteAdapter { movie ->
            mainViewModel.navigateToDetail(movie)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupRecyclerView()
        observeUiState()
    }

    private fun setupToolbar() {
        binding?.toolbarFavorite?.apply {
            setNavigationIcon(ResourcesCompat.getDrawable(resources, R.drawable.ic_back, null))
            setNavigationOnClickListener {
                mainViewModel.navigateBack()
            }
            applyStatusBarPadding()
        }
    }

    private fun setupRecyclerView() {
        binding?.rvFavorite?.apply {
            adapter = favoriteAdapter
            layoutManager = LinearLayoutManager(requireContext())
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

    private fun handleUiState(state: FavoriteUiState) {
        binding?.apply {
            pgFavorite.isVisible = state.isLoading
            rvFavorite.isVisible = !state.isLoading && state.favorite.isNotEmpty()
            tvFavoriteEmpty.isVisible = !state.isLoading && state.favorite.isEmpty()

            favoriteAdapter.submitList(state.favorite)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
