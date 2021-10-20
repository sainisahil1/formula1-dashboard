package io.sahil.f1dashboard.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.sahil.f1dashboard.data.models.Race
import io.sahil.f1dashboard.data.network.RetrofitInstance
import io.sahil.f1dashboard.data.network.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentViewModel: ViewModel() {

    private var yearListLiveData: MutableLiveData<List<String>> = MutableLiveData()
    private var yearListErrorHandler: MutableLiveData<String> = MutableLiveData()

    private var raceListLiveData: MutableLiveData<List<Race>> = MutableLiveData()
    private var raceListErrorHandler: MutableLiveData<String> = MutableLiveData()

    private val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(Repository::class.java)

    private val tag = HomeFragmentViewModel::class.java.simpleName


    fun getYearListObserver(): MutableLiveData<List<String>> {
        return yearListLiveData
    }

    fun getRaceListObserver(): MutableLiveData<List<Race>> {
        return raceListLiveData
    }

    fun getYearListErrorHandler(): MutableLiveData<String> {
        return yearListErrorHandler
    }

    fun getRaceListErrorHandler(): MutableLiveData<String> {
        return raceListErrorHandler
    }


    fun fetchYear() {
        viewModelScope.launch(Dispatchers.IO){

            val call = retrofitInstance.getSeasons()
            Log.e(tag, "Fetch Years URL: ${call.request().url().url().path}")

            call.enqueue(object : Callback<List<String>>{

                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {
                    Log.e(tag, "Fetch Years Response: ${response.body().toString()}")

                    if(response.isSuccessful){
                        yearListLiveData.postValue(response.body())
                    } else {
                        yearListErrorHandler.postValue("Something went wrong. Please try again later.")
                    }
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    yearListErrorHandler.postValue(t.localizedMessage)
                }
            })
        }
    }


    fun fetchRaces(year: String){
        viewModelScope.launch(Dispatchers.IO){

            val call = retrofitInstance.getRaces(year)
            Log.e(tag, "Fetch Races URL: ${call.request().url().url().path}")

            call.enqueue(object: Callback<List<Race>>{
                override fun onResponse(call: Call<List<Race>>, response: Response<List<Race>>) {
                    Log.e(tag, "Fetch Races Response: ${response.body().toString()}")

                    if (response.isSuccessful){
                        raceListLiveData.postValue(response.body())
                    } else {
                        raceListErrorHandler.postValue("Something went wrong. Please try again later.")
                    }

                }

                override fun onFailure(call: Call<List<Race>>, t: Throwable) {
                    raceListErrorHandler.postValue(t.localizedMessage)
                }
            })

        }
    }






}