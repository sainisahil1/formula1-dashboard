package io.sahil.f1dashboard.ui.view.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import io.sahil.f1dashboard.R
import io.sahil.f1dashboard.ui.view.fragments.ResultFragment

class RaceListAdapter(val activity: FragmentActivity?): RecyclerView.Adapter<RaceListAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val raceName: TextView = itemView.findViewById(R.id.race_name)
        val raceDate: TextView = itemView.findViewById(R.id.race_date)
        val raceCard: MaterialCardView = itemView.findViewById(R.id.race_card)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.race_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.raceName.text = "Australian Grand Prix"
        holder.raceDate.text = "2020-06-18"

        holder.raceCard.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_frame, ResultFragment(), ResultFragment::class.java.simpleName)
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    override fun getItemCount(): Int {
        return 10;
    }


}