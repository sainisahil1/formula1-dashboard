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
import io.sahil.f1dashboard.databinding.FragmentResultBinding
import io.sahil.f1dashboard.ui.view.adapters.ResultAdapter

class ResultFragment: Fragment() {

    lateinit var fragmentContext: Context
    lateinit var fragmentResultBinding: FragmentResultBinding

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

        fragmentResultBinding.resultLayout.resultList.layoutManager = LinearLayoutManager(fragmentContext)
        fragmentResultBinding.resultLayout.resultList.adapter = ResultAdapter()





        return fragmentResultBinding.root
    }




}