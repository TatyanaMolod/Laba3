package com.example.test.network

import android.util.Log
import androidx.compose.ui.graphics.Color
import com.example.test.MarvelCardModel
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.UnknownHostException

data class MarvelResult(
    @field:Json(name = "data") val data: Data?
)

data class Data(
    @field:Json(name = "results") val results: List<Character>
)

data class Character(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "thumbnail") val thumbnail: Thumbnail?
)

data class Thumbnail(
    @field:Json(name = "path") val path: String?,
    @field:Json(name = "extension") val extension: String?
)


fun getMarvel(): List<MarvelCardModel>{
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(MarvelApi.API_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val service = retrofit.create(MarvelApi::class.java)
    val list: MutableList<MarvelCardModel> = mutableListOf()
    try {
        val res = service.getCharacters().execute().body()!!.data!!.results
        var k = 0
        res.forEach { item ->
            if (item.thumbnail!!.path.toString() != "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available") {
                list.add(
                    MarvelCardModel(
                        k,
                        item.name!!,
                        item.description!!,
                        item.thumbnail.path?.replace("http", "https") + "/portrait_incredible." + item.thumbnail.extension
                    )
                )
                k++
            }
        }
        Log.i("deb", list.toString())
    } catch (e: UnknownHostException) {
        list.add(MarvelCardModel(0, "Error","", ""))
    }

    return list
}
