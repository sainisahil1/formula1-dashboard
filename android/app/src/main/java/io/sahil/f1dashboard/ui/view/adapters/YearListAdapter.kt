package io.sahil.f1dashboard.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import io.sahil.f1dashboard.R

class YearListAdapter: RecyclerView.Adapter<YearListAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.year_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.yearTextView.text = "2020"
    }

    override fun getItemCount(): Int {
       return 10;
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var yearTextView: TextView = itemView.findViewById(R.id.year_text);



    }


}