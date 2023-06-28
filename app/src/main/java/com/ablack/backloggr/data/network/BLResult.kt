package com.ablack.backloggr.data.network

// only classes allowed to implement sealed classes w/i file
sealed class BLResult<T> {

    data class Success<T>(val data: T) : BLResult<T>()

    data class Failure<T>(val error: Exception) : BLResult<T>()

}