package id.adr.mobile.moviesbyparkee.presentation.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import id.adr.mobile.moviesbyparkee.R
import id.adr.mobile.moviesbyparkee.databinding.ActivityMainBinding
import id.adr.mobile.moviesbyparkee.utils.Constants.ARGS_KEY_MOVIE_MODEL
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHost) as NavHostFragment
        navController = navHostFragment.navController

        observeUiState()
    }

    private fun observeUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    state.navigation?.let { navigation ->
                        handleNavigation(navigation)
                        viewModel.onNavigationConsumed()
                    }
                }
            }
        }
    }

    private fun handleNavigation(navigation: MainNavigation) {
        when (navigation) {
            is MainNavigation.ToDetail -> {
                val movieJson = Gson().toJson(navigation.movie)
                val bundle = bundleOf(ARGS_KEY_MOVIE_MODEL to movieJson)
                navController.navigate(R.id.action_global_to_detail_fragment, bundle)
            }
            is MainNavigation.ToFavorite -> {
                navController.navigate(R.id.action_home_fragment_to_favorite_fragment)
            }
            is MainNavigation.Back -> {
                navController.navigateUp()
            }
        }
    }
}
