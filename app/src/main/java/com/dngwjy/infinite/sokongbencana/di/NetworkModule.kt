package com.dngwjy.infinite.sokongbencana.di

import com.dngwjy.infinite.sokongbencana.data.ApiService
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netModule= module {
    single{
        val timeOut = 60L
        return@single OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor { chain ->
                val req = chain.request()
                    .newBuilder()
                    .build()
                return@addInterceptor chain.proceed(req)
            }
            .build()
    }
    single{
        Retrofit.Builder().baseUrl("https://api.myjson.com/").client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
    single {
        createService<ApiService>(get())
    }
}
inline fun<reified T>createService(retrofit: Retrofit):T=retrofit.create(T::class.java)