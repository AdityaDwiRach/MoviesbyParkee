package id.adr.mobile.moviesbyparkee.presentation.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.adr.mobile.moviesbyparkee.BuildConfig
import id.adr.mobile.moviesbyparkee.R
import id.adr.mobile.moviesbyparkee.databinding.ItemDetailReviewAdapterBinding
import id.adr.mobile.moviesbyparkee.databinding.ItemHomeSummaryAdapterBinding
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel
import id.adr.mobile.moviesbyparkee.domain.model.MovieReviewItem
import id.adr.mobile.moviesbyparkee.presentation.home.adapter.HomeSummaryAdapter.ViewHolder
import id.adr.mobile.moviesbyparkee.utils.Constants.STRIP

class DetailReviewAdapter: ListAdapter<MovieReviewItem, DetailReviewAdapter.ViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemDetailReviewAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(val binding: ItemDetailReviewAdapterBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieReviewItem) = with(binding) {
            tvItemDetailReviewAuthor.text = item.author
            tvItemDetailReviewOverview.text = item.content
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<MovieReviewItem>() {
            override fun areItemsTheSame(
                oldItem: MovieReviewItem,
                newItem: MovieReviewItem
            ) = oldItem.author == newItem.author

            override fun areContentsTheSame(
                oldItem: MovieReviewItem,
                newItem: MovieReviewItem
            ) = oldItem == newItem

        }
    }
}