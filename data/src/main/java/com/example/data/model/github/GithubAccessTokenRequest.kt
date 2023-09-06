package com.example.data.model.github

import com.example.domain.model.github.GithubAccessTokenRequest as tokenRequestDomain
import com.example.data.model.github.GithubAccessTokenRequest as tokenRequestData
import com.google.gson.annotations.SerializedName

data class GithubAccessTokenRequest(
    @SerializedName("client_id")
    val clientId: String,

    @SerializedName("client_secret")
    val clientSecret: String,

    @SerializedName("code")
    val code: String
)

internal fun tokenRequestDomain.toData() = tokenRequestData(
    clientId = clientId,
    clientSecret = clientSecret,
    code = code
)