package com.example.newslider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newslider.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TitleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)


        return binding.root
    }


}