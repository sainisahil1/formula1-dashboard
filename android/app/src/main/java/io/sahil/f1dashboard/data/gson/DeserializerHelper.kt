package io.sahil.f1dashboard.data.gson

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class DeserializerHelper<T>(private val jsonKey: String) : JsonDeserializer<T> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): T {

        val content: JsonElement? = json?.asJsonObject?.get(jsonKey)

        return Gson().fromJson(content, typeOfT)
    }
}