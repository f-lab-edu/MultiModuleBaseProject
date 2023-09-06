package com.example.data.api

import com.example.data.model.github.GithubAccessTokenRequest
import com.example.data.model.github.GithubAccessTokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface GithubAPI {

    @POST("login/oauth/access_token")
    suspend fun getAccessToken(@Body request: GithubAccessTokenRequest): GithubAccessTokenResponse
}