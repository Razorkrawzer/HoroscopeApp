package com.george.horoscapp.data

import android.util.Log
import com.george.horoscapp.data.network.HoroscopeApiService
import com.george.horoscapp.domain.Repository
import com.george.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("", "Ha ocurrido un error ${it.message}") }

        return null
    }
}