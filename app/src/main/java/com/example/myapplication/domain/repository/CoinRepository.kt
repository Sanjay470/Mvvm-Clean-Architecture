package com.example.myapplication.domain.repository

import com.example.myapplication.data.remote.dto.CoinDetailsDto
import com.example.myapplication.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinsDetails(coinId:String):CoinDetailsDto
}