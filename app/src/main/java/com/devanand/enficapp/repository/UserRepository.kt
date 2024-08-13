package com.devanand.enficapp.repository

import com.devanand.enficapp.api.UserDataService
import com.devanand.enficapp.modal.UserModal
import javax.inject.Inject

class UserRepository @Inject constructor(val userDataService: UserDataService) {

    suspend fun getUserData() : List<UserModal>{
        return userDataService.getUserData()
    }
}