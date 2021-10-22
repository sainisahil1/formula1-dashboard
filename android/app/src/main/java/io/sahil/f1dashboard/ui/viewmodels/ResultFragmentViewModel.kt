package io.sahil.f1dashboard.ui.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.sahil.f1dashboard.data.models.Circuit
import io.sahil.f1dashboard.data.models.CircuitResponse
import io.sahil.f1dashboard.data.models.Result
import io.sahil.f1dashboard.data.models.ResultResponse
import io.sahil.f1dashboard.data.network.Repository
import io.sahil.f1dashboard.data.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import android.net.Uri


class ResultFragmentViewModel(): ViewModel() {

    var resultListLiveData: MutableLiveData<List<Result>> = MutableLiveData()
    var resultErrorHandler: MutableLiveData<String> = MutableLiveData()
    var circuitLiveData: MutableLiveData<Circuit> = MutableLiveData()
    var circuitErrorHandler: MutableLiveData<String> = MutableLiveData()

    private val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(Repository::class.java)

    private val tag = ResultFragmentViewModel::class.java.simpleName

    lateinit var fragmentContext: Context

    fun setContext(context: Context){
        fragmentContext = context
    }

    fun fetchResults(raceId: String){
        viewModelScope.launch(Dispatchers.IO){

            val call = retrofitInstance.getResult(raceId)
            Log.e(tag, "Fetch Result URL: ${call.request().url()}")

            call.enqueue(object: Callback<ResultResponse>{

                override fun onResponse(
                    call: Call<ResultResponse>,
                    response: Response<ResultResponse>
                ) {
                    Log.e(tag, "Fetch Result Response: ${response.body().toString()}")

                    if (response.isSuccessful){
                        resultListLiveData.postValue(response.body()?.results)
                    } else {
                        resultErrorHandler.postValue("Something went wrong. Please try again later.")
                    }

                }

                override fun onFailure(call: Call<ResultResponse>, t: Throwable) {
                    t.printStackTrace()
                    if (t.localizedMessage.contains("Unable to resolve host")){
                        resultErrorHandler.postValue("Please check your internet connection")
                    } else {
                        resultErrorHandler.postValue(t.localizedMessage)
                    }
                }

            })

        }
    }


    fun fetchCircuit(circuitId: String){
        viewModelScope.launch(Dispatchers.IO){

            val call = retrofitInstance.getCircuit(circuitId)
            Log.e(tag, "Fetch Circuit URL: ${call.request().url()}")

            call.enqueue(object: Callback<CircuitResponse>{

                override fun onResponse(
                    call: Call<CircuitResponse>,
                    response: Response<CircuitResponse>
                ) {
                    Log.e(tag, "Fetch Circuit Response: ${response.body().toString()}")

                    if (response.isSuccessful){
                        circuitLiveData.postValue(response.body()?.circuit)
                    } else {
                        circuitErrorHandler.postValue("Something went wrong. Please try again later.")
                    }

                }

                override fun onFailure(call: Call<CircuitResponse>, t: Throwable) {
                    t.printStackTrace()
                    if (t.localizedMessage.contains("Unable to resolve host")){
                        circuitErrorHandler.postValue("Please check your internet connection")
                    } else {
                        circuitErrorHandler.postValue(t.localizedMessage)
                    }
                }

            })

        }
    }


    fun openMap(){
        val geoUri = "http://maps.google.com/maps?q=loc:${circuitLiveData.value?.lat},${circuitLiveData.value?.lng}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
        fragmentContext.startActivity(intent)
    }







}