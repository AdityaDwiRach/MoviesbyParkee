package id.adr.mobile.moviesbyparkee.presentation.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.adr.mobile.moviesbyparkee.BuildConfig
import id.adr.mobile.moviesbyparkee.R
import id.adr.mobile.moviesbyparkee.databinding.ItemFavoriteAdapterBinding
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.utils.Constants.STRIP
import id.adr.mobile.moviesbyparkee.utils.Constants.YYYY
import id.adr.mobile.moviesbyparkee.utils.Constants.YYYY_MM_DD
import id.adr.mobile.moviesbyparkee.utils.toDateTimeDisplay

class FavoriteAdapter(
    private val onItemClicked: (MovieItemModel) -> Unit
): ListAdapter<MovieItemModel, FavoriteAdapter.ViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemFavoriteAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        val binding: ItemFavoriteAdapterBinding,
        val onItemClicked: (MovieItemModel) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieItemModel) = with(binding) {
            ivItemFavorite.load("${BuildConfig.IMAGE_BASE_URL}${item.posterPath}")
            tvItemFavoriteTitle.text = item.title
            tvItemFavoriteReleaseDate.text =
                "${root.context.getString(R.string.home_movie_released_title)} $STRIP ${
                    item.releaseDate.toDateTimeDisplay(
                        YYYY_MM_DD,
                        YYYY
                    )
                }"
            tvItemFavoriteOverview.text = item.overview

            root.setOnClickListener { onItemClicked(item) }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<MovieItemModel>() {
            override fun areItemsTheSame(
                oldItem: MovieItemModel,
                newItem: MovieItemModel
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MovieItemModel,
                newItem: MovieItemModel
            ) = oldItem == newItem

        }
    }
}