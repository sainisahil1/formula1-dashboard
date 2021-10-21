package io.sahil.f1dashboard.ui.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import io.sahil.f1dashboard.R
import io.sahil.f1dashboard.ui.viewmodels.HomeFragmentViewModel

class YearListAdapter(
    private var yearList: MutableList<String>,
    private var currentPos: Int = 0,
    private val context: Context,
    private val homeFragmentViewModel: HomeFragmentViewModel
    ): RecyclerView.Adapter<YearListAdapter.ViewHolder>() {


    fun updateList(updatedList: MutableList<String>) {
        this.yearList = updatedList
        notifyDataSetChanged()
        callInitRaces(yearList[0])
    }

    private fun callInitRaces(year: String){
        homeFragmentViewModel.fetchRaces(year)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.year_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.yearTextView.text = yearList[position]

        holder.yearTextView.setOnClickListener {
            currentPos = position
            homeFragmentViewModel.fetchRaces(yearList[position])
        }

        if (position == currentPos){
            holder.yearTextView.setBackgroundColor(context.getColor(R.color.colorPrimary))
            holder.yearTextView.setTextColor(context.getColor(R.color.white))
        } else {
            holder.yearTextView.setBackgroundColor(context.getColor(R.color.white))
            holder.yearTextView.setTextColor(context.getColor(R.color.colorDark))
        }


    }

    override fun getItemCount(): Int {
       return yearList.size;
    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var yearTextView: TextView = itemView.findViewById(R.id.year_text)
    }


}