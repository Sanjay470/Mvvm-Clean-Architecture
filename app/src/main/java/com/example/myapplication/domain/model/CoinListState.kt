package com.example.myapplication.domain.model

data class CoinListState(
    val isLoading:Boolean=false,
    val coins:List<Coin> = emptyList(),
    val error:String=""
)
