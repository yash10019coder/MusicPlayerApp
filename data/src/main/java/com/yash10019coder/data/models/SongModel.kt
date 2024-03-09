package com.yash10019coder.data.models


import com.google.gson.annotations.SerializedName

data class SongModel(
    @SerializedName("accent")
    var accent: String,
    @SerializedName("artist")
    var artist: String,
    @SerializedName("cover")
    var cover: String,
    @SerializedName("date_created")
    var dateCreated: String,
    @SerializedName("date_updated")
    var dateUpdated: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("sort")
    var sort: Any?,
    @SerializedName("status")
    var status: String,
    @SerializedName("top_track")
    var topTrack: Boolean,
    @SerializedName("url")
    var url: String,
    @SerializedName("user_created")
    var userCreated: String,
    @SerializedName("user_updated")
    var userUpdated: String
)
