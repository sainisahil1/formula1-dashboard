package io.sahil.f1dashboard.ui.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.sahil.f1dashboard.R
import io.sahil.f1dashboard.data.models.Race
import io.sahil.f1dashboard.databinding.FragmentHomeBinding
import io.sahil.f1dashboard.ui.view.adapters.RaceListAdapter
import io.sahil.f1dashboard.ui.view.adapters.YearListAdapter
import io.sahil.f1dashboard.ui.viewmodels.HomeFragmentViewModel

class HomeFragment: Fragment() {

    private lateinit var fragmentContext: Context
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private var yearList = mutableListOf<String>()
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    private lateinit var yearListAdapter: YearListAdapter
    private var raceList = mutableListOf<Race>()
    private lateinit var raceListAdapter: RaceListAdapter


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
        initStaticViews()
        initViewModel()
        return fragmentHomeBinding.root
    }

    private fun refreshPage() {
        yearList.clear()
        raceList.clear()
        yearListAdapter.notifyDataSetChanged()
        fragmentHomeBinding.yearLayout.yearRecyclerview.visibility = View.GONE
        fragmentHomeBinding.yearLayout.yearErrorHandler.visibility = View.GONE
        fragmentHomeBinding.yearLayout.yearLoadingLayout.visibility = View.VISIBLE
        fragmentHomeBinding.raceLoadingCard.visibility = View.VISIBLE
        fragmentHomeBinding.raceRecyclerview.visibility = View.GONE
        fragmentHomeBinding.raceErrorCard.visibility = View.GONE
        homeFragmentViewModel.fetchYears()
        fragmentHomeBinding.homeSwipeLayout.isRefreshing = false

    }


    private fun initStaticViews() {
        fragmentHomeBinding.header.backButton.visibility = View.GONE
        fragmentHomeBinding.yearLayout.yearRecyclerview.visibility = View.GONE
        fragmentHomeBinding.yearLayout.yearErrorHandler.visibility = View.GONE
        fragmentHomeBinding.yearLayout.yearLoadingLayout.visibility = View.VISIBLE
        fragmentHomeBinding.raceLoadingCard.visibility = View.VISIBLE
        fragmentHomeBinding.raceRecyclerview.visibility = View.GONE
        fragmentHomeBinding.raceErrorCard.visibility = View.GONE
        homeFragmentViewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        yearListAdapter = YearListAdapter(
            yearList = yearList,
            context = fragmentContext,
            homeFragmentViewModel = homeFragmentViewModel,
            fragmentHomeBinding = fragmentHomeBinding
        )
        raceListAdapter = RaceListAdapter(activity, raceList)
        fragmentHomeBinding.lifecycleOwner = this
        fragmentHomeBinding.yearLayout.yearRecyclerview.adapter = yearListAdapter
        fragmentHomeBinding.yearLayout.yearRecyclerview.layoutManager = LinearLayoutManager(fragmentContext)
        fragmentHomeBinding.raceRecyclerview.adapter = raceListAdapter
        fragmentHomeBinding.raceRecyclerview.layoutManager = LinearLayoutManager(fragmentContext)
        fragmentHomeBinding.homeSwipeLayout.setColorSchemeResources(R.color.colorPrimary)
        fragmentHomeBinding.homeSwipeLayout.setOnRefreshListener { refreshPage() }
        fragmentHomeBinding.homeViewModel = homeFragmentViewModel
        fragmentHomeBinding.yearLayout.homeViewModel = homeFragmentViewModel
    }


    private fun initViewModel(){
        homeFragmentViewModel.yearListLiveData.observe(viewLifecycleOwner, Observer<List<String>>{
            if (it != null){
                yearListAdapter.updateList(it.toMutableList())
                fragmentHomeBinding.yearLayout.yearLoadingLayout.visibility = View.GONE
                fragmentHomeBinding.yearLayout.yearErrorHandler.visibility = View.GONE
                fragmentHomeBinding.yearLayout.yearRecyclerview.visibility = View.VISIBLE
            }
        })

        homeFragmentViewModel.yearErrorHandler.observe(viewLifecycleOwner, Observer {
            if (it != null){
                fragmentHomeBinding.yearLayout.yearLoadingLayout.visibility = View.GONE
                fragmentHomeBinding.yearLayout.yearRecyclerview.visibility = View.GONE
                fragmentHomeBinding.yearLayout.yearErrorHandler.visibility = View.VISIBLE
            }
        })

        homeFragmentViewModel.raceListLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null){
                fragmentHomeBinding.raceLoadingCard.visibility = View.GONE
                raceListAdapter.updateRaceList(it.toMutableList())
                fragmentHomeBinding.raceRecyclerview.visibility = View.VISIBLE
                fragmentHomeBinding.raceErrorCard.visibility = View.GONE
            }
        })

        homeFragmentViewModel.raceErrorHandler.observe(viewLifecycleOwner, Observer {
            if (it != null){
                fragmentHomeBinding.raceLoadingCard.visibility = View.GONE
                fragmentHomeBinding.raceRecyclerview.visibility = View.GONE
                fragmentHomeBinding.raceErrorCard.visibility = View.VISIBLE
            }
        })

        homeFragmentViewModel.fetchYears()

    }






}