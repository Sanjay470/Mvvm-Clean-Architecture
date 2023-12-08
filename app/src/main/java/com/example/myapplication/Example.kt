package com.example.myapplication

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

fun main(array: Array<String>) {


    val data= flowOf(1,2,3,4,5,67,8,9,10).flowOn(Dispatchers.IO)

    runBlocking {
        data.filter { value ->

            value%2==0

        }.

        collect{
            Log.d("main", "main: $it")
        }
    }

}

