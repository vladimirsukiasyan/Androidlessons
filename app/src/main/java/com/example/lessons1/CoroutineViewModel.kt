package com.example.lessons1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CoroutineViewModel:ViewModel() {

    init {
        viewModelScope.launch {
            factorial(12)
            Job
        }
    }

    suspend fun factorial(number: Int){
        var result = 1
        for (i in 12 downTo 1){
            result*=i
            delay(500)
            Log.d("MA", result.toString())
        }
    }
}