package com.george.horoscapp.data

import android.util.Log
import com.george.horoscapp.data.network.HoroscopeApiService
import com.george.horoscapp.data.network.response.PredictionResponse
import com.george.horoscapp.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionResponse? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it }
            .onFailure { Log.i("", "Ha ocurrido un error ${it.message}") }

        return null
    }
}