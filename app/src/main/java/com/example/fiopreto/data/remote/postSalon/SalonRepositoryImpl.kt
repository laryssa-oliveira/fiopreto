package com.example.fiopreto.data.remote.postSalon

import android.content.Context
import android.content.SharedPreferences
import com.example.fiopreto.PostSalon
import com.example.fiopreto.R
import com.example.fiopreto.data.Constants
import com.example.fiopreto.data.SalonRepository
import com.example.fiopreto.data.local.LocalDataSource
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.data.remote.toModel
import com.example.fiopreto.extensions.wrapResponse

class SalonRepositoryImpl(
    private val service: SalonService,
    private val localDataSource: LocalDataSource

) : SalonRepository {

    override suspend fun getPostsSalon(): ResultWrapper<List<PostSalon>> =
        when(val result = callPostsSalonEndpoint()) {
            is ResultWrapper.Failure -> ResultWrapper.Failure(result.error!!)
            is ResultWrapper.Success -> ResultWrapper.Success(
                result.data?.salonResp?.map {
                    it.toModel()
                }?: listOf()
            )
        }

    private suspend fun callPostsSalonEndpoint() = wrapResponse {
        service.getPostsSaloon(
            //auth = localDataSource.getHeadersFromPreferences()[Constants.HEADER_AUTH] ?: ""
            /*authorization = "Bearer eyJhbGciOiJIUzM4NCIsInR5cCI6IkpXVCJ9.eyJzdWIiOnsiaWQiOjgsIm5hbWUiOiJBbmEgSnVsaWEiLCJlbWFpbCI6ImFuYWp1bGlhQGhvdG1haWwuY29tIn0sImlhdCI6MTYyMTkwOTQ5NSwiZXhwIjoxNjIyNTE0Mjk1fQ.rq8TJUXDiggyGNtN8HrZo6XMzuIdcZrWRynfoysxwz2YcOSYGexL-dx8nN65t4IZ"
            client = localDataSource.getHeadersFromPreferences()[HEADER_CLIENT] ?: "",
            uid = localDataSource.getHeadersFromPreferences()[HEADER_UID] ?: ""*/
        )
    }
    /*
    class SessionManager (context: Context) {
        private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

        companion object {
            const val USER_TOKEN = "user_token"
        }

        /**
         * Function to save auth token
         */
        fun saveAuthToken(token: String) {
            val editor = prefs.edit()
            editor.putString(USER_TOKEN, token)
            editor.apply()
        }

        /**
         * Function to fetch auth token
         */
        fun fetchAuthToken(): String? {
            return prefs.getString(USER_TOKEN, null)
        }
    }*/

}