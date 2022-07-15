package com.zharfan.myfavancha.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.zharfan.myfavancha.R
import com.zharfan.myfavancha.adapter.ListAnimeAdapter
import com.zharfan.myfavancha.data.Anime
import com.zharfan.myfavancha.data.AnimeCharacter
import com.zharfan.myfavancha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var listAnime: ArrayList<Anime> = arrayListOf()
    companion object{
        private const val TAG = "MainActivity"
    }

    private lateinit var listAnimeAdapter: ListAnimeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showAnimeList()
    }


    private fun showAnimeList() = with(binding) {
        listAnime.addAll(AnimeCharacter.listData)
        listAnimeAdapter = ListAnimeAdapter(listAnime)
        with(rvAnimeList) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAnimeAdapter
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)

        return super.onCreateOptionsMenu(menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_search -> {
                val item = R.id.action_search
                val searchView = item as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        Log.i(TAG,"Filter Berhasil $listAnimeAdapter")
                        listAnimeAdapter.filter.filter(newText)
                        return false
                    }

                })
            }
            R.id.action_about -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }

            android.R.id.home -> onBackPressed()
        }
    }
}