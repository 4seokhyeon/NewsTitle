package com.example.newslider

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newslider.databinding.ActivityMainBinding
import com.example.newslider.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TitleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTitleBinding.inflate(layoutInflater)
        recyclerView = binding.recyclerView

        // TitleManager 구현체 초기화 (실제 데이터를 가져오는 방식에 따라 수정 필요)
        val titleManager = NewsTitleimpl.getInstance()

        // RecyclerView 설정
        adapter = TitleAdapter(titleManager.getProducts())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    private fun isLandScape(): Boolean {
        val context = context
        if (context != null) {
            val configuration = context.resources.configuration
            return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        }
        return false
    }
}