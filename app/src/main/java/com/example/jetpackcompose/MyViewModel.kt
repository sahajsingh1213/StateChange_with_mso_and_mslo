package com.example.jetpackcompose

import android.location.Address
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyViewModel:ViewModel() {
    var count = mutableStateOf(1)
    var a = mutableStateOf("Waiting for data ")

    fun increasei(){
        count.value+=1
        a.value = "data is fetched ${count.value}"


    }




}

//2001-01-25
fun <T:String> T.Datereverse():String
{
    if(this.length == 10)
    return "${this.subSequence(8,10)}-${this.subSequence(5,7)}-${this.subSequence(0,4)}"
    else
        return this

}