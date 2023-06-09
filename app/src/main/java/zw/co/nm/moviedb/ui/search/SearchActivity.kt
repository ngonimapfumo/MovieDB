package zw.co.nm.moviedb.ui.search

import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import zw.co.nm.moviedb.databinding.ActivitySearchBinding
import zw.co.nm.moviedb.ui.adapters.SearchAdapter
import zw.co.nm.moviedb.ui.viewmodels.MoviesViewModel
import zw.co.nm.moviedb.utils.SmallCache

class SearchActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var adapter: SearchAdapter
    private var queryStr: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        moviesViewModel.searchMulti(query!!)
        moviesViewModel.searchMulti.observe(this) { response ->
            queryStr = query
            val data = response.body.results
            if (response.body.totalPages > 1) {
                binding.constraintLayoutPages.visibility = VISIBLE
                binding.nextB.isEnabled = moviesViewModel.page != response.body.totalPages
            }
            adapter = SearchAdapter(data)
            binding.searchRecycler.adapter = adapter


        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        //sa
      //  moviesViewModel.page = 1
        return false
    }


    private fun setUpView() {
        binding.searchView.setOnQueryTextListener(this)
        binding.searchView.onActionViewExpanded()
        moviesViewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.nextB.setOnClickListener {
            moviesViewModel.page++
            moviesViewModel.searchMulti(queryStr!!)
        }
        binding.prevB.setOnClickListener {
            if (moviesViewModel.page != 1) {
                moviesViewModel.page--
                moviesViewModel.searchMulti(queryStr!!)
            } else {
                return@setOnClickListener
            }
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }


}