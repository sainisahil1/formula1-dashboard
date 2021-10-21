package io.sahil.f1dashboard.data.gson

import com.google.gson.*
import java.lang.reflect.Type

class DeserializerHelper<T>(private val jsonKey: String) : JsonDeserializer<T> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): T {

        val content: JsonObject? = json?.asJsonObject
        val listObject: JsonArray? = content?.getAsJsonArray(jsonKey)


        return Gson().fromJson(listObject, typeOfT)
    }
}