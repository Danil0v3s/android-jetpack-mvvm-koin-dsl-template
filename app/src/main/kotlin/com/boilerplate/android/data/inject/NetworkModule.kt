package com.boilerplate.android.data.inject

import com.boilerplate.android.data.network.NetworkConstants
import com.boilerplate.android.data.network.category.DummyApi
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single {
        provideDefaultOkHttpClient()
    }
    single { provideRetrofit(get()) }
    single { provideDummyService(get()) }
}

fun provideDefaultOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(client)
        .baseUrl(NetworkConstants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun provideDummyService(retrofit: Retrofit): DummyApi =
    retrofit.create(DummyApi::class.java)