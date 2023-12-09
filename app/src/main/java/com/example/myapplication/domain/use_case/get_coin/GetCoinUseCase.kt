package com.example.myapplication.domain.use_case.get_coin

import com.example.myapplication.common.Resource
import com.example.myapplication.data.remote.dto.CoinDetailsDto
import com.example.myapplication.data.remote.dto.toCoin
import com.example.myapplication.data.remote.dto.toCoinDetails
import com.example.myapplication.domain.model.Coin
import com.example.myapplication.domain.model.CoinDetails
import com.example.myapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private  val repository: CoinRepository
) {

    operator fun invoke(coinId:String):Flow<Resource<CoinDetails>> = flow {
      try {
             emit(Resource.Loading())
             val response=repository.getCoinsDetails(coinId).toCoinDetails()
             emit(Resource.Success(response))

      }catch (e:HttpException){
          emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred"))
      }
       catch (e:IOException){
           emit(Resource.Error("couldn't reach to server. Check Your internet Connection"))
       }
    }
}