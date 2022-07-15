package com.zharfan.myfavancha.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zharfan.myfavancha.activity.DetailActivity
import com.zharfan.myfavancha.data.Anime
import com.zharfan.myfavancha.databinding.ItemAnimeLayoutBinding
import java.util.*
import kotlin.collections.ArrayList


class ListAnimeAdapter(private val listAnimeAdapter: ArrayList<Anime>) :
    RecyclerView.Adapter<ListAnimeAdapter.MyViewHolder>(), Filterable {

    var listAnimeAdapterFilter = ArrayList<Anime>()

    init {
        listAnimeAdapterFilter = listAnimeAdapter
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListAnimeAdapter.MyViewHolder {
        return MyViewHolder(
            ItemAnimeLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ListAnimeAdapter.MyViewHolder, position: Int) {
        holder.bind(listAnimeAdapter[position])

    }

    override fun getItemCount(): Int = listAnimeAdapter.size

    inner class MyViewHolder(private val binding: ItemAnimeLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: Anime) = with(binding) {
            tvAnimeName.text = anime.characterName
            tvAnimeDesc.text = anime.characterDescription

            Glide.with(itemView.context)
                .load(anime.characterPicture)
                .into(imgAnimeCharacter)

            animeListButton.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_ANIME, anime)
                itemView.context.startActivity(intent)
            }

        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isNotEmpty()) {
                    val resultList = ArrayList<Anime>()
                    for (row in listAnimeAdapter) {
                        if (row.characterName.lowercase(Locale.ROOT).contains(
                                charSearch.lowercase(
                                    Locale.ROOT
                                )
                            )
                        ) {
                            resultList.add(row)
                        }
                    }
                    listAnimeAdapterFilter = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = listAnimeAdapterFilter
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listAnimeAdapterFilter =
                    results?.values as ArrayList<Anime>
                notifyDataSetChanged()

            }

        }
    }

}



