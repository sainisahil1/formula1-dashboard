package io.sahil.f1dashboard.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import io.sahil.f1dashboard.R

class ResultListAdapter: RecyclerView.Adapter<ResultListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val pos: TextView = itemView.findViewById(R.id.pos)
        val layout: ConstraintLayout = itemView.findViewById(R.id.result_list_item_layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.result_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.pos.text = "POS"
        if (position%2==0){
            holder.layout.setBackgroundResource(R.color.white)
        } else {
            holder.layout.setBackgroundResource(R.color.background_grey)
        }

    }

    override fun getItemCount(): Int {
        return 20
    }


}