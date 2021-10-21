package io.sahil.f1dashboard.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.sahil.f1dashboard.data.gson.DeserializerHelper
import io.sahil.f1dashboard.data.models.Circuit
import io.sahil.f1dashboard.data.models.Race
import io.sahil.f1dashboard.data.models.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class RetrofitInstance {

    companion object{

        const val baseUrl = "http://f1dashboard-env.eba-r6tmgvmb.ap-south-1.elasticbeanstalk.com/"

        fun getRetrofitInstance(): Retrofit {

            /*val gson = GsonBuilder()
                .enableComplexMapKeySerialization()
                .registerTypeAdapter(Circuit::class.java, DeserializerHelper<Circuit>("circuit"))
                .registerTypeAdapter(Race::class.java, DeserializerHelper<Race>("races"))
                .registerTypeAdapter(Result::class.java, DeserializerHelper<Result>("results"))
                .create()*/


            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

    }

}