package io.sahil.f1dashboard.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.sahil.f1dashboard.R
import io.sahil.f1dashboard.data.models.Result
import io.sahil.f1dashboard.databinding.ResultListItemBinding

class ResultListAdapter(private var resultList: MutableList<Result>): RecyclerView.Adapter<ResultListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ResultListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(result: Result, position: Int){
            binding.result = result
            if (position%2==0){
                binding.resultListItemLayout.setBackgroundResource(R.color.white)
            } else {
                binding.resultListItemLayout.setBackgroundResource(R.color.background_grey)
            }
        }

    }

    fun setUpdatedList(updatedList: MutableList<Result>){
        resultList = updatedList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val resultListItemBinding: ResultListItemBinding = DataBindingUtil.inflate(inflater, R.layout.result_list_item, parent, false)
        return ViewHolder(resultListItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(resultList[position], position)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }


}