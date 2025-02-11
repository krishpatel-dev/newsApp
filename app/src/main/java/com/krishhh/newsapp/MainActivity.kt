package com.krishhh.newsapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)

        // Initial API call to fetch news

        fetchNews()

        // Set up Swipe-to-Refresh listener
        swipeRefreshLayout.setOnRefreshListener {
            fetchNews() // Call the API again when swiped
        }
    }

    private fun fetchNews() {
        // Show the refreshing spinner
        swipeRefreshLayout.isRefreshing = true

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsApiService = retrofit.create(NewsApiService::class.java)

        val call = newsApiService.getTopHeadlines("us", "385b95730e2c4689b4dc47a6cb890fd4")
        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                // Stop the refreshing spinner
                swipeRefreshLayout.isRefreshing = false

                if (response.isSuccessful) {
                    response.body()?.let {
                        adapter = NewsAdapter(it.articles)
                        recyclerView.adapter = adapter
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Failed to fetch news", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                // Stop the refreshing spinner
                swipeRefreshLayout.isRefreshing = false

                Log.e("MainActivity", "Error fetching news", t)
                Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
