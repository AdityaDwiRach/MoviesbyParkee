package id.adr.mobile.moviesbyparkee.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.adr.mobile.moviesbyparkee.BuildConfig
import id.adr.mobile.moviesbyparkee.R
import id.adr.mobile.moviesbyparkee.databinding.ItemHomeSummaryAdapterBinding
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.utils.Constants.STRIP
import id.adr.mobile.moviesbyparkee.utils.Constants.YYYY
import id.adr.mobile.moviesbyparkee.utils.Constants.YYYY_MM_DD
import id.adr.mobile.moviesbyparkee.utils.toDateTimeDisplay

class HomeSummaryAdapter(
    private val onItemClicked: (MovieItemModel) -> Unit
): ListAdapter<MovieItemModel, HomeSummaryAdapter.ViewHolder>(DiffCallback)  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemHomeSummaryAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        val binding: ItemHomeSummaryAdapterBinding,
        val onItemClicked: (MovieItemModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieItemModel) = with(binding) {
            ivItemHomeSummary.load("${BuildConfig.IMAGE_BASE_URL}${item.posterPath}")
            tvItemHomeSummaryTitle.text = item.title
            tvItemHomeSummaryReleaseDate.text =
                "${root.context.getString(R.string.home_movie_released_title)} $STRIP ${
                    item.releaseDate.toDateTimeDisplay(
                        YYYY_MM_DD,
                        YYYY
                    )
                }"

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