package com.example.jetpackcompose.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jetpackcompose.R


@Composable
fun UserCard(
    painter: String,

    modifier: Modifier = Modifier
)
{
    ElevatedCard (
        modifier = modifier
            .size(160.dp)
            .offset(y = 60.dp)
            .clip(CircleShape),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp),

        )
    //https://www.hollywoodreporter.com/wp-content/uploads/2014/02/new_godzilla_poster.jpg
    {
        Box(modifier = Modifier.fillMaxSize()){
            AsyncImage(
                model = painter,
                contentDescription = "User's image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        BorderStroke(3.dp, Color.DarkGray),
                        CircleShape
                    )
                    .border(
                        BorderStroke(9.dp, Color(0xFF202126)),
                        CircleShape
                    )
            )
        }

    }




}


@Composable
fun cloumnBox(
    modifier: Modifier = Modifier,
    name:String,
    email:String,
    Dob:String,
    address: String,
    Phone:String,
    password:String
)
{
    val scrollState = rememberScrollState()
    var a = remember {
        mutableStateOf("hello world, I am $name")
    }
    Column(modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF0086FE))
            .weight(.2f)){}
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFF202126))
                .weight(1f)

        ){
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color(0xFF202126)),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally


            ) {


                Text(
                    text = "${a.value}",
                    color = Color.White
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.2f)
                        .offset(y = 60.dp)
                        .background(Color(0xFF202126))

                        .horizontalScroll(scrollState),

                    verticalAlignment = Alignment . CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    UserInfoButton(onclick = { a.value = name }, infoName = "Name")
                    Spacer(modifier = Modifier.width(20.dp))
                    UserInfoButton(onclick = { a.value = email }, infoName = "Email")
                    Spacer(modifier = Modifier.width(20.dp))
                    UserInfoButton(onclick = { a.value = Dob }, infoName = "Dob")
                    Spacer(modifier = Modifier.width(20.dp))
                    UserInfoButton(onclick = { a.value = address }, infoName = "Address")
                    Spacer(modifier = Modifier.width(20.dp))
                    UserInfoButton(onclick = { a.value = Phone }, infoName = "Phone_no.")
                    Spacer(modifier = Modifier.width(20.dp))
                    UserInfoButton(onclick = { a.value = password }, infoName = "Password")


                }
            }

        }

    }
}

@Preview
@Composable
fun finalRender(
    name:String = "",
    email:String = "",
    Dob:String = "",
    address: String = "",
    Phone:String = "",
    password:String = "",
    painter:String = ""


){

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(388.dp)
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                cloumnBox(
                    name =name,
                    email = email,
                    Dob = Dob,
                    address = address,
                    Phone = Phone,
                    password = password
                )
                UserCard(painter = painter)
            }

        }



@Composable
fun UserInfoButton(onclick:()->Unit,infoName:String){
    Button(onClick = onclick,
        Modifier
            .height(50.dp)
            .width(115.dp)) {
        Text(text = infoName)

    }
}