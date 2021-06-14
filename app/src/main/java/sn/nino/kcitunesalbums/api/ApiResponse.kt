package sn.nino.kcitunesalbums.api

import com.squareup.moshi.Json
// parses and stored in this object the response
// from itunes search api
data class ApiResponse(
    @field:Json(name = "resultCount") val resultCount: Int?,
    @field:Json(name = "results") val results: MutableList<Results>?
    )
