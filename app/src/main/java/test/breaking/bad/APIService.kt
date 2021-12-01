package test.breaking.bad

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getCharactersByName(@Url url:String, @Query("name") name:String?): Response<List<CharactersResponseItem>>
}