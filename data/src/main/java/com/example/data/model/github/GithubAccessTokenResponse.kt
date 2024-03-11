package com.example.data.model.github

//import com.example.domain.model.github.GithubAccessTokenResponse as responseDomain
//import com.example.data.model.github.GithubAccessTokenResponse as responseData
import com.google.gson.annotations.SerializedName

data class GithubAccessTokenResponse(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("token_type")
    val tokenType: String,

    @SerializedName("scope")
    val scope: String
)

//internal fun responseData.toDomain() = responseDomain(
//    accessToken = accessToken,
//    tokenType = tokenType,
//    scope = scope
//)