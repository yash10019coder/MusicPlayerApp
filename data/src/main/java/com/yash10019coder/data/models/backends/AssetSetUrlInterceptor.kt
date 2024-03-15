package com.yash10019coder.data.models.backends

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AssetSetUrlInterceptor @Inject constructor(
    @CoverImageUrl private val coverImageUrl: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        return try {
            val songsList = response.body as List<SongModel>
            songsList.forEach { songModel ->
                songModel.cover = "$coverImageUrl/${songModel.cover}"
            }
            response
        } catch (e: Exception) {
            response
        }
    }
}
