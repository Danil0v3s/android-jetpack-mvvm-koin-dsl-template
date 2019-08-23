package com.boilerplate.android.data.database.converter

import androidx.room.TypeConverter
import com.boilerplate.android.business.model.Category
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class ListCategoryTypeConverter {

    private var moshi: Moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromCategoryList(listOfCategories: List<Category>?): String? {
        if (listOfCategories == null || listOfCategories.isEmpty()) {
            return null
        }

        val parameterizedType =
            Types.newParameterizedType(List::class.java, Category::class.java)
        val adapter: JsonAdapter<List<Category>> = moshi.adapter(parameterizedType)

        return adapter.toJson(listOfCategories)
    }

    @TypeConverter
    fun toCategoryList(listCategoryStr: String?): List<Category>? {
        if (listCategoryStr == null || listCategoryStr.isEmpty()) {
            return null
        }

        val parameterizedType = Types.newParameterizedType(List::class.java, Category::class.java)
        val adapter: JsonAdapter<List<Category>> = moshi.adapter(parameterizedType)

        return adapter.fromJson(listCategoryStr)
    }
}