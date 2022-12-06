package az.ekvileptika.basecomposeproject.data

import az.ekvileptika.basecomposeproject.data.characters.ResponseModel
import retrofit2.http.GET

interface RetrofitApi {
    @GET("character")
    suspend fun getInfo(): ResponseModel
}