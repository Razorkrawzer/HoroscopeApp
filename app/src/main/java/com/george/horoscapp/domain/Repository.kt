package com.george.horoscapp.domain

import com.george.horoscapp.data.network.response.PredictionResponse

interface Repository {

    suspend fun getPrediction(sign: String): PredictionResponse?

}