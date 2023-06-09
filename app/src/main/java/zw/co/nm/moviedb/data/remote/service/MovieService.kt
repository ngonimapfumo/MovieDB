package zw.co.nm.moviedb.data.remote.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import zw.co.nm.moviedb.data.remote.networkmodel.GetCombinedCreditsResponse
import zw.co.nm.moviedb.data.remote.networkmodel.GetCreditsResponse
import zw.co.nm.moviedb.data.remote.networkmodel.GetMovieDetailResponse
import zw.co.nm.moviedb.data.remote.networkmodel.GetPersonResponse
import zw.co.nm.moviedb.data.remote.networkmodel.GetPopularMoviesListResponse
import zw.co.nm.moviedb.data.remote.networkmodel.GetSimilarMoviesResponse
import zw.co.nm.moviedb.data.remote.networkmodel.GetTrailersResponse
import zw.co.nm.moviedb.data.remote.networkmodel.SearchMultiResponse

interface MovieService {

    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") movieId: Int
    ): Response<GetMovieDetailResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): Response<GetPopularMoviesListResponse>

    @GET("movie/{id}/similar")
    suspend fun getSimilarMoviesList(
        @Path("id") movieId: Int
    ): Response<GetSimilarMoviesResponse>

    @GET("movie/{id}/credits")
    suspend fun getCredits(
        @Path("id") movieId: Int
    ): Response<GetCreditsResponse>

    @GET("person/{id}")
    suspend fun getPerson(
        @Path("id") personId: Int
    ): Response<GetPersonResponse>

    @GET("search/multi")
    suspend fun searchMulti(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("include_adult") include_adult: Boolean
    ): Response<SearchMultiResponse>

    @GET("person/{id}/combined_credits")
    suspend fun getCombinedCredits(
        @Path("id") query: Int
    ): Response<GetCombinedCreditsResponse>

    @GET("movie/{id}/videos")
    suspend fun getTrailers(
        @Path("id") movieId: Int
    ): Response<GetTrailersResponse>

}