package io.sahil.f1dashboard.ui.view.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import io.sahil.f1dashboard.R
import io.sahil.f1dashboard.data.models.Race
import io.sahil.f1dashboard.databinding.RaceListItemBinding
import io.sahil.f1dashboard.ui.view.fragments.ResultFragment

class RaceListAdapter(
    private val activity: FragmentActivity?,
    private var raceList: MutableList<Race>,
    ): RecyclerView.Adapter<RaceListAdapter.ViewHolder>(){

    fun updateRaceList(updatedList: MutableList<Race>){
        this.raceList = updatedList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val raceListItemBinding: RaceListItemBinding = DataBindingUtil.inflate(inflater, R.layout.race_list_item, parent, false)
        return ViewHolder(raceListItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(raceList[position], activity)
    }

    override fun getItemCount(): Int {
        return raceList.size;
    }

    class ViewHolder(private val raceListItemBinding: RaceListItemBinding) : RecyclerView.ViewHolder(raceListItemBinding.root){

        fun bind(race: Race, activity: FragmentActivity?){
            raceListItemBinding.race = race
            raceListItemBinding.raceCard.setOnClickListener {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.add(R.id.main_frame, ResultFragment(circuitId = race.circuitId, raceID = race.raceId), ResultFragment::class.java.simpleName)
                    ?.addToBackStack(null)
                    ?.commit()
            }
        }

    }


}