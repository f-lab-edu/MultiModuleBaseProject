package com.example.data.repository

//import com.example.data.api.GithubAPI
//import com.example.data.model.github.toData
//import com.example.data.model.github.toDomain
//import com.example.domain.model.github.GithubAccessTokenRequest
//import com.example.domain.model.github.GithubAccessTokenResponse
//import com.example.domain.repository.GithubRepository
//import javax.inject.Inject
//import javax.inject.Named
//
//class GithubRepositoryImpl @Inject constructor(
//    @Named("githubApi")
//    val githubAPI: GithubAPI,
//) : GithubRepository {
//    // TODO. 해당 suspend logic은 어떤 coroutine 에서 동작할까?
//    override suspend fun githubAccessTokenRequest(githubAccessTokenRequest: GithubAccessTokenRequest): GithubAccessTokenResponse {
//        return githubAPI.getAccessToken(githubAccessTokenRequest.toData()).toDomain()
//    }
//
//}