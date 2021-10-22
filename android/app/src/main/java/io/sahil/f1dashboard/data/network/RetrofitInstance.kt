package io.sahil.f1dashboard.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {

    companion object{

        private const val baseUrl = "http://f1dashboard-env.eba-r6tmgvmb.ap-south-1.elasticbeanstalk.com/"

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