package id.adr.mobile.moviesbyparkee.presentation.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import id.adr.mobile.moviesbyparkee.BuildConfig
import id.adr.mobile.moviesbyparkee.R
import id.adr.mobile.moviesbyparkee.databinding.FragmentDetailBinding
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.presentation.detail.adapter.DetailReviewAdapter
import id.adr.mobile.moviesbyparkee.presentation.main.MainViewModel
import id.adr.mobile.moviesbyparkee.utils.Constants.ARGS_KEY_MOVIE_MODEL
import id.adr.mobile.moviesbyparkee.utils.Constants.ONE
import id.adr.mobile.moviesbyparkee.utils.Constants.STRIP
import id.adr.mobile.moviesbyparkee.utils.Constants.TWO_HUNDRED
import id.adr.mobile.moviesbyparkee.utils.Constants.YYYY
import id.adr.mobile.moviesbyparkee.utils.Constants.YYYY_MM_DD
import id.adr.mobile.moviesbyparkee.utils.Constants.ZERO
import id.adr.mobile.moviesbyparkee.utils.applyStatusBarPadding
import id.adr.mobile.moviesbyparkee.utils.toDateTimeDisplay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val viewModel: DetailViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    private val binding get() = _binding

    private val reviewAdapter by lazy { DetailReviewAdapter() }

    private var errorDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { args ->
            args.getString(ARGS_KEY_MOVIE_MODEL)?.let {
                viewModel.movieArgs = Gson().fromJson(it, MovieItemModel::class.java)
            }
        }
        setupRecyclerView()
        setupToolbar()
        setupListener()
        observeUiState()
        viewModel.getMovieReview(resources.configuration.locales[ZERO].toLanguageTag())
    }

    private fun setupToolbar() {
        binding?.toolbarDetail?.apply {
            setNavigationIcon(ResourcesCompat.getDrawable(resources, R.drawable.ic_back, null))
            setNavigationOnClickListener {
                mainViewModel.navigateBack()
            }
            applyStatusBarPadding()
        }
    }

    private fun setupRecyclerView() {
        binding?.apply {
            rvDetailReview.apply {
                adapter = reviewAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    private fun setupListener() {
        binding?.apply {
            ivDetailFavorite.setOnClickListener {
                viewModel.toggleFavorite()
            }
            ivDetailShare.setOnClickListener {
                shareMovieTitle()
            }
            nsvDetail.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                onScrollChanged(scrollY)
            }
        }
    }

    private fun shareMovieTitle() {
        val title = viewModel.movieArgs?.title ?: return
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, title)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }

    private fun onScrollChanged(scrollY: Int) {
        binding?.apply {
            val toolbarHeight = toolbarDetail.height
            if (toolbarHeight > ZERO) {
                if (scrollY >= toolbarHeight) {
                    if (toolbarDetail.isVisible) {
                        toolbarDetail.animate()
                            .alpha(ZERO.toFloat())
                            .setDuration(TWO_HUNDRED.toLong())
                            .withEndAction { toolbarDetail.isVisible = false }
                            .start()
                    }
                } else {
                    if (!toolbarDetail.isVisible) {
                        toolbarDetail.isVisible = true
                        toolbarDetail.alpha = ZERO.toFloat()
                        toolbarDetail.animate()
                            .alpha(ONE.toFloat())
                            .setDuration(TWO_HUNDRED.toLong())
                            .withEndAction(null)
                            .start()
                    }
                }
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

    private fun handleUiState(state: DetailUiState) {
        binding?.apply {
            pgDetail.isVisible = state.isLoading
            val movieDetail = state.movieDetail?.movie

            ivItemHomeBackdrop.load("${BuildConfig.IMAGE_BASE_URL}${movieDetail?.backdropPath}")
            tvDetailTitle.text = movieDetail?.title
            tvDetailReleaseDate.text =
                "${root.context.getString(R.string.home_movie_released_title)} $STRIP ${
                    movieDetail?.releaseDate?.toDateTimeDisplay(
                        YYYY_MM_DD,
                        YYYY
                    )
                }"
            tvItemFavoriteOverview.text = movieDetail?.overview
            reviewAdapter.submitList(state.movieDetail?.reviews)

            ivDetailFavorite.setImageResource(
                if (state.isFavorite) R.drawable.ic_favorite_on else R.drawable.ic_favorite_off
            )
        }

        if (state.errorMessage != null) {
            showErrorDialog()
        } else {
            errorDialog?.dismiss()
        }
    }

    private fun showErrorDialog() {
        if (errorDialog?.isShowing == true) return

        errorDialog = AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.error_title))
            .setPositiveButton(getString(R.string.retry)) { _, _ ->
                viewModel.getMovieReview(resources.configuration.locales[ZERO].toLanguageTag())
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
