package com.example.jetpackcompose

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.R
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.ui.theme.DataClass.Result
import com.example.jetpackcompose.ui.theme.DataClass.User
import com.example.jetpackcompose.ui.theme.cloumnBox
import com.example.jetpackcompose.ui.theme.finalRender
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

import kotlin.text.StringBuilder

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    private val vm by viewModels<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //exeption handler
        var Handler = CoroutineExceptionHandler { _, throwable ->
            Log.d("mytag","Exeption is $throwable")
        }



                    setContent {

                        var Users = "no"
                        var UserI = MutableLiveData<User>()


                        var list = mutableListOf<String>(
                            "https://www.hollywoodreporter.com/wp-content/uploads/2014/02/new_godzilla_poster.jpg",
                            "https://i.pinimg.com/474x/9a/79/e9/9a79e9c7e0296737e00f967aadc56f72.jpg",
                            "https://m.media-amazon.com/images/M/MV5BOGFjYWNkMTMtMTg1ZC00Y2I4LTg0ZTYtN2ZlMzI4MGQwNzg4XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg",
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRuNdl-J7xwP7DIYaerniPZ-yqXLL_CIHNirabClCC8qlDOjrr49TubkIn3Ig&s",
                            "https://img.freepik.com/free-photo/closeup-shot-beautiful-butterfly-with-interesting-textures-orange-petaled-flower_181624-7640.jpg?size=626&ext=jpg",
                            "https://www.hollywoodreporter.com/wp-content/uploads/2014/02/new_godzilla_poster.jpg",
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShUBTbuG-g2RJcLSx5vdBO_OBODXTiiLxfmw&usqp=CAU",
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnIOpjil1igWfSXoaGO8R-gUI5E2D3eRF9eA&usqp=CAU",
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfTkFeN9WqpmwLrPPTzI1xCV5uYpMSL5-wMQ&usqp=CAU",
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_JscbylLmdNMSix2PAr7-AXA7UI2Ut7W6sw&usqp=CAU"


                        )

                        LaunchedEffect(key1 = list) {
vm.job.join()

                            Log.d("mytag", "nameMerabhai = ${vm.Results.get(0)} ${vm.Results.size}")

                            if (vm.Results.get(0) != " ") {
                                Log.d("mytag", "results is non-empty before")
                            } else {
                                Log.d("mytag", "results is empty is before")
                            }


                        }


                        var size = if (vm.Results.size != 10) 1 else vm.Results.size
                        if (vm.Results.size > 1) {
                            vm.increasei()
                        }



                        Box(
                            Modifier.fillMaxSize()
                        ) {


                            LazyRow {


                                items(size) {
                                    if (vm.Results.isNotEmpty()) {
                                        finalRender(
                                            name = "${vm.Results.get(it)} ${vm.Results.size}",
                                            email = "${vm.email.get(it)}",
                                            Dob = "${vm.Dob.get(it)}",
                                            address = "${vm.Address.get(it)}",
                                            Phone = "${vm.phone.get(it)}",
                                            password = "${vm.password.get(it)}",
                                            painter = "${vm.ResultsPicture.get(it)}"
                                        )
                                    } else finalRender(
                                        name = "${Users} ${vm.Results.size}",
                                        email = "{Results.value.first().email }",
                                        Dob = "{Users.value[0].results[0].dob.date}",
                                        address = "{(Users.value[0].results[0].location.city)}",
                                        Phone = "{Users.value[0].results[0].phone}",
                                        password = "{Users.value[0].results[0].login.password}",
                                        painter = "{ResultsPicture.value[0]}"
                                    )


                                }
                            }

                            Button(onClick = {
                                vm.increasei()
                            }) {
                                Text(text = "${vm.a.value}")
                            }
                        }
                    }






        }


    }










