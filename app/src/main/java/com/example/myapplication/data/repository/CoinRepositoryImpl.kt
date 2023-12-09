package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.CoinPaprikaApi
import com.example.myapplication.data.remote.dto.CoinDetailsDto
import com.example.myapplication.data.remote.dto.CoinDto
import com.example.myapplication.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi
):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsDetails(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }

}