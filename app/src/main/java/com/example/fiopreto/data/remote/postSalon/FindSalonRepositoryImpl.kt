package com.example.fiopreto.data.remote.postSalon

import com.example.fiopreto.Cities
import com.example.fiopreto.data.Constants
import com.example.fiopreto.data.local.LocalDataSource
import com.example.fiopreto.data.FindSalonRepository
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.data.remote.toModel
import com.example.fiopreto.extensions.wrapResponse

class FindSalonRepositoryImpl(
    private val service: FindSalonService,
    private val localDataSource: LocalDataSource
) : FindSalonRepository {

    override suspend fun getCities(): ResultWrapper<List<Cities>> =
        when(val result = callFindSalonEndpoint()) {
            is ResultWrapper.Failure -> ResultWrapper.Failure(result.error!!)
            is ResultWrapper.Success -> ResultWrapper.Success(
                result.data?.cityResp?.map {
                    it.toModel()
                }?: listOf()
            )
        }

    private suspend fun callFindSalonEndpoint() = wrapResponse {
        service.getCities(
            authorization = localDataSource.getHeadersFromPreferences()[Constants.HEADER_AUTHORIZATION] ?: ""
            /*authorization = "Bearer eyJhbGciOiJIUzM4NCIsInR5cCI6IkpXVCJ9.eyJzdWIiOnsiaWQiOjgsIm5hbWUiOiJBbmEgSnVsaWEiLCJlbWFpbCI6ImFuYWp1bGlhQGhvdG1haWwuY29tIn0sImlhdCI6MTYyMTkwOTQ5NSwiZXhwIjoxNjIyNTE0Mjk1fQ.rq8TJUXDiggyGNtN8HrZo6XMzuIdcZrWRynfoysxwz2YcOSYGexL-dx8nN65t4IZ"
            client = localDataSource.getHeadersFromPreferences()[HEADER_CLIENT] ?: "",
            uid = localDataSource.getHeadersFromPreferences()[HEADER_UID] ?: ""*/
        )
    }

}