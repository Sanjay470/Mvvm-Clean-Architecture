package com.example.myapplication.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.CoinListState
import com.example.myapplication.domain.use_case.get_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CoinListViewModel @Inject constructor(
   private val getCoinUseCase: GetCoinsUseCase
):ViewModel(){
  private val _state = mutableStateOf(CoinListState())
   val state :State<CoinListState>  = _state



   private  fun getCoins(){
      getCoinUseCase().onEach { result ->

         when(result){

            is Resource.Loading ->{
               _state.value= CoinListState(isLoading = true)
            }
            is Resource.Success ->{
               _state.value= CoinListState(coins = result.data?: emptyList())
            }
            is Resource.Error ->{
                _state.value=CoinListState(error = result.message?:"An unexpected error occurred")
            }

         }


      }.launchIn(viewModelScope)
   }

}


