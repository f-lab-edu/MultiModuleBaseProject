package com.example.domain.model.github

import com.google.gson.annotations.SerializedName

data class GithubAccessTokenRequest(
    @SerializedName("client_id")
    val clientId: String,

    @SerializedName("client_secret")
    val clientSecret: String,

    @SerializedName("code")
    val code: String
)
