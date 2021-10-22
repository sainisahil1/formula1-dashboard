package io.sahil.f1dashboard.ui.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.sahil.f1dashboard.R
import io.sahil.f1dashboard.data.models.Circuit
import io.sahil.f1dashboard.data.models.Result
import io.sahil.f1dashboard.databinding.FragmentResultBinding
import io.sahil.f1dashboard.ui.view.adapters.RaceListAdapter
import io.sahil.f1dashboard.ui.view.adapters.ResultListAdapter
import io.sahil.f1dashboard.ui.viewmodels.ResultFragmentViewModel

class ResultFragment(private val circuitId: String?, private val raceID: String?): Fragment() {

    private lateinit var fragmentContext: Context
    private lateinit var fragmentResultBinding: FragmentResultBinding
    private var resultList = mutableListOf<Result>()
    private lateinit var resultListAdapter: ResultListAdapter
    private lateinit var resultFragmentViewModel: ResultFragmentViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.fragmentContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentResultBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)

        initStaticViews()
        initViewModel()


        return fragmentResultBinding.root
    }

    private fun refreshPage(){
        fragmentResultBinding.circuitLayout.circuitLoadingLayout.visibility = View.VISIBLE
        fragmentResultBinding.circuitLayout.circuitDetailLayout.visibility = View.GONE
        fragmentResultBinding.circuitLayout.circuitErrorLayout.visibility = View.GONE
        fragmentResultBinding.resultLayout.resultLoadingCard.visibility = View.VISIBLE
        fragmentResultBinding.resultLayout.titleLayout.visibility = View.GONE
        fragmentResultBinding.resultLayout.resultList.visibility = View.GONE
        fragmentResultBinding.resultLayout.resultListErrorCard.visibility = View.GONE

        resultList.clear()
        resultListAdapter.notifyDataSetChanged()

        raceID?.let { resultFragmentViewModel.fetchResults(it) }
        circuitId?.let { resultFragmentViewModel.fetchCircuit(it) }

        fragmentResultBinding.refreshLayout.isRefreshing = false

    }

    private fun initStaticViews(){

        fragmentResultBinding.lifecycleOwner = this
        fragmentResultBinding.circuitLayout.circuitLoadingLayout.visibility = View.VISIBLE
        fragmentResultBinding.circuitLayout.circuitDetailLayout.visibility = View.GONE
        fragmentResultBinding.circuitLayout.circuitErrorLayout.visibility = View.GONE
        fragmentResultBinding.resultLayout.resultLoadingCard.visibility = View.VISIBLE
        fragmentResultBinding.resultLayout.titleLayout.visibility = View.GONE
        fragmentResultBinding.resultLayout.resultList.visibility = View.GONE
        fragmentResultBinding.resultLayout.resultListErrorCard.visibility = View.GONE

        fragmentResultBinding.header.backButton.visibility = View.VISIBLE
        fragmentResultBinding.header.backButton.setOnClickListener { goBack() }

        resultFragmentViewModel = ViewModelProvider(this).get(ResultFragmentViewModel::class.java)
        resultFragmentViewModel.setContext(fragmentContext)

        resultListAdapter = ResultListAdapter(resultList)

        fragmentResultBinding.resultLayout.resultList.layoutManager = LinearLayoutManager(fragmentContext)
        fragmentResultBinding.resultLayout.resultList.adapter = resultListAdapter
        fragmentResultBinding.circuitLayout.resultViewModel = resultFragmentViewModel
        fragmentResultBinding.resultLayout.resultViewModel = resultFragmentViewModel
        fragmentResultBinding.refreshLayout.setOnRefreshListener {
            refreshPage()
        }

    }

    private fun goBack(){
        (fragmentContext as AppCompatActivity).supportFragmentManager.popBackStackImmediate()
    }

    private fun initViewModel(){

        resultFragmentViewModel.circuitLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null){
                fragmentResultBinding.circuitLayout.circuitDetailLayout.visibility = View.VISIBLE
                fragmentResultBinding.circuitLayout.circuitErrorLayout.visibility = View.GONE
                fragmentResultBinding.circuitLayout.circuitLoadingLayout.visibility = View.GONE
            }
        })

        resultFragmentViewModel.circuitErrorHandler.observe(viewLifecycleOwner, Observer {
            if (it != null){
                fragmentResultBinding.circuitLayout.circuitDetailLayout.visibility = View.GONE
                fragmentResultBinding.circuitLayout.circuitErrorLayout.visibility = View.VISIBLE
                fragmentResultBinding.circuitLayout.circuitLoadingLayout.visibility = View.GONE
            }
        })

        resultFragmentViewModel.resultListLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null){
                resultListAdapter.setUpdatedList(it.toMutableList())
                fragmentResultBinding.resultLayout.resultLoadingCard.visibility = View.GONE
                fragmentResultBinding.resultLayout.titleLayout.visibility = View.VISIBLE
                fragmentResultBinding.resultLayout.resultList.visibility = View.VISIBLE
                fragmentResultBinding.resultLayout.resultListErrorCard.visibility = View.GONE
            }
        })

        resultFragmentViewModel.resultErrorHandler.observe(viewLifecycleOwner, Observer {
            if (it != null){
                fragmentResultBinding.resultLayout.resultLoadingCard.visibility = View.GONE
                fragmentResultBinding.resultLayout.titleLayout.visibility = View.GONE
                fragmentResultBinding.resultLayout.resultList.visibility = View.GONE
                fragmentResultBinding.resultLayout.resultListErrorCard.visibility = View.VISIBLE
            }
        })


        circuitId?.let { resultFragmentViewModel.fetchCircuit(it) }
        raceID?.let { resultFragmentViewModel.fetchResults(it) }




    }






}