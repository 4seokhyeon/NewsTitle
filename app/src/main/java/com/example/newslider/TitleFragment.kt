package com.example.newslider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TitleFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TitleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_title, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)

        val titleManager = NewsTitleimpl.getInstance()
        val titleList = titleManager.titleList

        adapter = TitleAdapter(requireContext(), titleList)
        recyclerView.adapter = adapter

        // 리사이클러뷰의 레이아웃 매니저 설정 (예: 세로 스크롤)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        return view
    }



}