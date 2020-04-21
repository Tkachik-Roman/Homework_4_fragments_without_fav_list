package com.example.homework_4_fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), MovieListFragment.OnMoviesClickListener {

    override fun onMoviesClick(item: RecyclerMoviesItem) {
        openMoviesDetailed(item)
    }

    lateinit var movieListFragment: MovieListFragment
    lateinit var movieFavoriteFragment: MovieFavoriteFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.btnNav)

        // show movieListFragment as default fragment when app is open
        movieListFragment = MovieListFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MovieListFragment(), MovieListFragment.TAG)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    movieListFragment = MovieListFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, movieListFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.favorite -> {
                    movieFavoriteFragment = MovieFavoriteFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, movieFavoriteFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is MovieListFragment) {
            fragment.listener = this
        }
    }

    fun openMoviesDetailed(item: RecyclerMoviesItem) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MoviesDetailedFragment.newInstance(item.image, item.description), MoviesDetailedFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
            super.onBackPressed()
        }
    }
}