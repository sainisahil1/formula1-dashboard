package io.sahil.f1dashboard.ui.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.sahil.f1dashboard.R
import io.sahil.f1dashboard.databinding.FragmentHomeBinding
import io.sahil.f1dashboard.ui.view.adapters.RaceListAdapter
import io.sahil.f1dashboard.ui.view.adapters.YearListAdapter

class HomeFragment: Fragment() {

    private lateinit var fragmentContext: Context;
    private lateinit var fragmentHomeBinding: FragmentHomeBinding;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.fragmentContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        fragmentHomeBinding.yearLayout.yearRecyclerview.adapter = YearListAdapter()
        fragmentHomeBinding.yearLayout.yearRecyclerview.layoutManager = LinearLayoutManager(fragmentContext)

        fragmentHomeBinding.raceRecyclerview.adapter = RaceListAdapter(activity)
        fragmentHomeBinding.raceRecyclerview.layoutManager = LinearLayoutManager(fragmentContext)





        return fragmentHomeBinding.root
    }






}