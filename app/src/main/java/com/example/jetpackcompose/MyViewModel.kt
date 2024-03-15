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

    var Results = mutableStateListOf<String>()
    var ResultsPicture = mutableStateListOf<String>()
    var email = mutableStateListOf<String>()
    var Dob = mutableStateListOf<String>()
    var Address = mutableStateListOf<String>()
    var phone = mutableStateListOf<String>()
    var password = mutableStateListOf<String>()



    val retrofitBuilder = Retrofit.Builder().baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(RandamApi::class.java)


    val job = viewModelScope.launch {
        repeat(10) {
            val response = retrofitBuilder.getMyData()!!
            if (response.isSuccessful) {
                for (mydata in response.body()?.results!!) {
                    Log.d("mytag", "name = ${mydata.name}")
                    Results.add(mydata.name.first)
                    ResultsPicture.add(mydata.picture.large)
                    email.add(mydata.email)
                    Dob.add(mydata.dob.date.removeRange(10, 24).Datereverse())
                    Address.add("Country: ${mydata.location.country} \n State: ${mydata.location.state} \n City:${mydata.location.city}")
                    phone.add(mydata.phone)
                    password.add(mydata.login.password)
                }

            }
        }

//king


    }

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