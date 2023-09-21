package com.george.horoscapp.domain

import com.george.horoscapp.data.network.response.PredictionResponse
import com.george.horoscapp.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sign: String): PredictionModel?

}