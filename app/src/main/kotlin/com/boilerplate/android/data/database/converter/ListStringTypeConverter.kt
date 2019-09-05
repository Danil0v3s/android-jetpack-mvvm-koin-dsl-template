package com.boilerplate.android.data.database.converter

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class ListStringTypeConverter {

    private var moshi: Moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromList(list: List<String>?): String? {
        if (list == null || list.isEmpty()) {
            return null
        }

        val parameterizedType =
            Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(parameterizedType)

        return adapter.toJson(list)
    }

    @TypeConverter
    fun toList(s: String): List<String>? {
        if (s == null || s.isEmpty()) {
            return null
        }

        val parameterizedType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(parameterizedType)

        return adapter.fromJson(s)
    }
}