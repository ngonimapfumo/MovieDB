package zw.co.nm.moviedb.utils

import zw.co.nm.moviedb.data.remote.Response
import zw.co.nm.moviedb.data.remote.networkmodel.GetMovieDetailResponse

object SmallCache {

    val cacheMap
    = mutableMapOf<Int, Response<GetMovieDetailResponse>>()
}