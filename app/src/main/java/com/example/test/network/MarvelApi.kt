package com.example.test.network
import androidx.compose.runtime.MutableState
import com.example.test.MarvelCardModel
import retrofit2.Call
import retrofit2.http.GET

interface MarvelApi {

    @GET("characters?limit=10&apikey=fb16069e6f075dce47a9c194c8baadec&ts=1&hash=247ecc73b1e5ad2868bce1f509470b87")
    fun getCharacters(): Call<MarvelResult>

    companion object{
        const val API_URL = "https://gateway.marvel.com:443/v1/public/"
    }
}

//https://gateway.marvel.com:443/v1/public/characters?limit=10&apikey=fb16069e6f075dce47a9c194c8baadec&ts=1&hash=247ecc73b1e5ad2868bce1f509470b87