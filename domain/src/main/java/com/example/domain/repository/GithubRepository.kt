package com.example.domain.repository

import com.example.domain.model.github.GithubAccessTokenRequest
import com.example.domain.model.github.GithubAccessTokenResponse

interface GithubRepository {
    suspend fun githubAccessTokenRequest(githubAccessTokenRequest: GithubAccessTokenRequest): GithubAccessTokenResponse
}