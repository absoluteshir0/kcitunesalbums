package sn.nino.kcitunesalbums.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import sn.nino.kcitunesalbums.R
import sn.nino.kcitunesalbums.api.Results
import sn.nino.kcitunesalbums.databinding.ItemListBinding


class AlbumListAdapter(
    var context:Context,
    var list: MutableList<Results>,
    var listener: IAdapter
) : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie SingleItemBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of ItemListBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    // bind the items with each item of the list which then will be
    // shown in recycler view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            // album list scroll animation
            var lastPosition = -1
            val animation: Animation = AnimationUtils.loadAnimation(
                context,
                if (position > lastPosition) R.anim.up_from_bottom else R.anim.down_from_top
            )
            holder.itemView.startAnimation(animation)
            lastPosition = position

            //hide line for last item on
            if(position == itemCount - 1) holder.binding.line.visibility = View.GONE else holder.binding.line.visibility = View.VISIBLE

            // populate data from API
            // to list items
            with(list[position]){
                // used Coil library to load image
                // from url
                // and easily add placeholder
                binding.ivAlbumaArt.load(this.artworkUrl100){
                    crossfade(true)
                    placeholder(R.drawable.album_placeholder)
                    transformations(CircleCropTransformation())
                }
                binding.tvTrackName.text = if(this.trackName.isNullOrEmpty()) this.collectionName else this.trackName
                binding.tvGendre.text = this.primaryGenreName

                // this is my work around
                // since some array does not have the [trackPrice] parameter
                // so this
                // checks for the [wrapperType]
                // if equal to "track" --> display trackPrice
                // or else display collectionPrice
                binding.tvPrice.text = "$"+if(this.wrapperType.equals("track")) this.trackPrice.toString() else this.collectionPrice.toString()
                binding.container.setOnClickListener {
                    listener.onClick(this)
                }



            }
        }
    }

    // return the size of list
    override fun getItemCount(): Int {
        return list.size
    }


    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

    // listener interface to be accessed by
    // activity to easily pass list data
    interface IAdapter{
        fun onClick(results: Results)
    }
}