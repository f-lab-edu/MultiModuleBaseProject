package com.example.domain.model.github

import com.google.gson.annotations.SerializedName

data class GithubAccessTokenResponse(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("token_type")
    val tokenType: String,

    @SerializedName("scope")
    val scope: String
)