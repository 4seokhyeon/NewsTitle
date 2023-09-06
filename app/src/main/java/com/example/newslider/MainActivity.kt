package com.example.newslider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.newslider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            // 화면을 처음 띄울 때 TitleFragment를 표시합니다.
            showTitleFragment()
        }
    }

    fun showTitleFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val titleFragment = TitleFragment()
        transaction.replace(R.id.framout, titleFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun showDetailFragment(item: NewItem) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putParcelable("item", item)
        detailFragment.arguments = bundle
        transaction.replace(R.id.framout, detailFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}