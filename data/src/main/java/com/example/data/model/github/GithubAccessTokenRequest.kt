package com.example.data.model.github

// TODO. domain layer 도 request data layer 도 request 따로 class 명만 바뀌면 as 로 import 캐스팅 안받아도 될텐데 굳이??
//import com.example.domain.model.github.GithubAccessTokenRequest as tokenRequestDomain
//import com.example.data.model.github.GithubAccessTokenRequest as tokenRequestData
import com.google.gson.annotations.SerializedName

data class GithubAccessTokenRequest(
    @SerializedName("client_id")
    val clientId: String,

    @SerializedName("client_secret")
    val clientSecret: String,

    @SerializedName("code")
    val code: String
)
//
//internal fun tokenRequestDomain.toData() = tokenRequestData(
//    clientId = clientId,
//    clientSecret = clientSecret,
//    code = code
//)