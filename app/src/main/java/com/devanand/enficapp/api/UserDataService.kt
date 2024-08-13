package com.devanand.enficapp.api

import com.devanand.enficapp.modal.UserModal
import retrofit2.http.GET

interface UserDataService {

        @GET("users")
        suspend fun getUserData() : List<UserModal>
}