package id.adr.mobile.moviesbyparkee.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.adr.mobile.moviesbyparkee.BuildConfig
import id.adr.mobile.moviesbyparkee.databinding.ItemHomeBackdropAdapterBinding
import id.adr.mobile.moviesbyparkee.domain.model.MovieItemModel

class HomeBackdropAdapter(
    private val onItemClicked: (MovieItemModel) -> Unit
): ListAdapter<MovieItemModel, HomeBackdropAdapter.ViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemHomeBackdropAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        val binding: ItemHomeBackdropAdapterBinding,
        val onItemClicked: (MovieItemModel) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieItemModel) = with(binding) {
            ivItemHomeBackdrop.load("${BuildConfig.IMAGE_BASE_URL}${item.backdropPath}")

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