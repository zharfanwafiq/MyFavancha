package com.zharfan.myfavancha.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zharfan.myfavancha.R
import com.zharfan.myfavancha.data.Anime
import com.zharfan.myfavancha.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    private lateinit var anime: Anime

    companion object {
        const val EXTRA_ANIME = "package com.zharfan.myfavancha.activity.EXTRA_ANIME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setBundle()
        setData()
        initToolbar()
    }


    private fun setBundle() {
        anime = intent.getParcelableExtra<Anime>(EXTRA_ANIME) as Anime
    }

    private fun setData() = with(binding) {
        Glide.with(imgDetail)
            .load(anime.characterPicture)
            .into(imgDetail)
        tvAnimeNameDetail.text = anime.characterName
        tvAnimeAgeDetail.text = anime.characterAge.toString()
        tvAnimeDescDetail.text = anime.characterDescription

    }

    private fun initToolbar() {
        supportActionBar?.apply {
            title = anime.characterName
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()

            R.id.action_share -> {
                val animeName = anime.characterName
                val shareAnime = Intent(Intent.ACTION_SEND).putExtra(
                    Intent.EXTRA_TEXT,
                    "You Are Send $animeName"
                ).setType("text/plain")
                val shareIntent = Intent.createChooser(shareAnime, null)
                startActivity(shareIntent)

            }
        }
        return super.onOptionsItemSelected(item)
    }


}