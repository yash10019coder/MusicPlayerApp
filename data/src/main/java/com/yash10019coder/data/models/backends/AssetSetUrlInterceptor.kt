package com.yash10019coder.data.models.backends

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject

class AssetSetUrlInterceptor @Inject constructor(
    @CoverImageUrl private val coverImageUrl: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val newResponse = Response.Builder()
            .request(request)
            .protocol(response.protocol)
            .code(response.code)
            .message(response.message)
            .headers(response.headers)

        return try {
            val songsList = response.body as SongsResponse
            songsList.data.forEach { songModel ->
                songModel.cover = "$coverImageUrl/${songModel.cover}"
            }
            newResponse.body(songsList as ResponseBody)
                .build()
        } catch (e: Exception) {
            response
        }
    }
}
