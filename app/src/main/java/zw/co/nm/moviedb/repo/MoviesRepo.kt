package zw.co.nm.moviedb.repo

import retrofit2.Response
import zw.co.nm.moviedb.data.remote.NetworkManager
import zw.co.nm.moviedb.model.GetCreditsResponse
import zw.co.nm.moviedb.model.GetMovieDetailResponse
import zw.co.nm.moviedb.model.GetPopularMoviesListResponse
import zw.co.nm.moviedb.model.GetSimilarMoviesResponse
import zw.co.nm.moviedb.model.SearchMultiResponse
import zw.co.nm.moviedb.utils.GeneralUtil.apiCall

class MoviesRepo {
    suspend fun getPopularMovies(page: Int):zw.co.nm.moviedb.data.remote.Response<GetPopularMoviesListResponse> =
       apiCall {NetworkManager.apiService.getPopularMovies(page)}

    suspend fun getMovieDetails(movieId: Int): Response<GetMovieDetailResponse> =
        NetworkManager.apiService.getMovieDetail(movieId)


    suspend fun getSimilarMoviesList(movieId: Int): Response<GetSimilarMoviesResponse> =
        NetworkManager.apiService.getSimilarMoviesList(movieId)

    suspend fun getCredits(movieId: Int): Response<GetCreditsResponse> =
        NetworkManager.apiService.getCredits(movieId)

    suspend fun searchMulti(query: String): Response<SearchMultiResponse> =
        NetworkManager.apiService.searchMulti(query, true)


}