package com.norm.myappweather

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.norm.myappweather.screens.MainCard
import com.norm.myappweather.screens.TabLayout
import com.norm.myappweather.ui.theme.MyAppWeatherTheme

const val API_KEY = "9ffe10fdc3d2447681a100356231812"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getData("Novosibirsk", this)
            MyAppWeatherTheme {
                Image(
                    painter = painterResource(id = R.drawable.bg_img_weather_3_9_20),
                    contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.8f),
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}

private fun getData(city: String, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY" +
            "&q=$city" +
            "&days=" +
            "3" +
            "&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        com.android.volley.Request.Method.GET,
        url,
        { response ->
        },
        {
            Log.d("MyLog", "VolleyError: $it")
        }
    )
}