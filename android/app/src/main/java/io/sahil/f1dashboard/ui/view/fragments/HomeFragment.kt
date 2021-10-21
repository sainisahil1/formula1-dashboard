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

        initStaticView()
        initViewModel()





        return fragmentHomeBinding.root
    }


    private fun initStaticView() {
        homeFragmentViewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        yearListAdapter = YearListAdapter(yearList = yearList, context = fragmentContext, homeFragmentViewModel = homeFragmentViewModel)
        raceListAdapter = RaceListAdapter(activity, raceList)
        fragmentHomeBinding.yearLayout.yearRecyclerview.adapter = yearListAdapter
        fragmentHomeBinding.yearLayout.yearRecyclerview.layoutManager = LinearLayoutManager(fragmentContext)
        fragmentHomeBinding.raceRecyclerview.adapter = raceListAdapter
        fragmentHomeBinding.raceRecyclerview.layoutManager = LinearLayoutManager(fragmentContext)
    }

    private fun initViewModel(){
        homeFragmentViewModel.getYearListObserver().observe(viewLifecycleOwner, Observer<List<String>>{
            if (it != null){
                yearListAdapter.updateList(it.toMutableList())
                fragmentHomeBinding.yearLayout.yearErrorHandler.visibility = View.GONE
                fragmentHomeBinding.yearLayout.yearRecyclerview.visibility = View.VISIBLE
            }
        })

        homeFragmentViewModel.getYearListErrorHandler().observe(viewLifecycleOwner, Observer {
            if (it != null){
                fragmentHomeBinding.yearLayout.yearRecyclerview.visibility = View.GONE
                fragmentHomeBinding.yearLayout.yearErrorHandler.visibility = View.VISIBLE
                fragmentHomeBinding.yearLayout.yearErrorText.text = "Error: $it"
            }
        })

        homeFragmentViewModel.getRaceListObserver().observe(viewLifecycleOwner, Observer {
            if (it != null){
                raceListAdapter.updateRaceList(it.toMutableList())
                fragmentHomeBinding.raceRecyclerview.visibility = View.VISIBLE
                fragmentHomeBinding.raceErrorLayout.visibility = View.GONE
            }
        })

        homeFragmentViewModel.getRaceListErrorHander().observe(viewLifecycleOwner, Observer {
            if (it != null){
                fragmentHomeBinding.raceRecyclerview.visibility = View.GONE
                fragmentHomeBinding.raceErrorLayout.visibility = View.VISIBLE
                fragmentHomeBinding.raceErrorText.text = it
            }
        })

        homeFragmentViewModel.fetchYears()

    }






}