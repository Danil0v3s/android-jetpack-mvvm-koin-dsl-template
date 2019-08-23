package com.boilerplate.android.data.inject

import com.boilerplate.android.data.network.category.CATEGORY_BASE_URL
import com.boilerplate.android.data.network.category.CategoryApi
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single {
        provideDefaultOkHttpClient()
    }
    single { provideRetrofit(get()) }
    single { provideCategoryService(get()) }
}

fun provideDefaultOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(client)
        .baseUrl(CATEGORY_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun provideCategoryService(retrofit: Retrofit): CategoryApi =
    retrofit.create(CategoryApi::class.java)