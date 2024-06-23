package com.example.weatherapp_mvvm.data.di
import com.example.weatherapp_mvvm.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getRetrofitBuilder(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun getBaseURl():String="https://api.openweathermap.org/data/2.5/weather?"

    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit):ApiService=retrofit.create(ApiService::class.java)

}