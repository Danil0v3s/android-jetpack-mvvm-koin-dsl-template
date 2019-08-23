package com.boilerplate.android.data.network.category

import com.boilerplate.android.business.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface CategoryApi {
    @GET("v2/5d08c0f2340000f79d5d9a31")
    fun fetchCategories(): Call<Category>
}