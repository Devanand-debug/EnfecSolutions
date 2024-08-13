package com.devanand.enficapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devanand.enficapp.modal.UserModal
import com.devanand.enficapp.repository.UserRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModal @Inject constructor(val userRepository: UserRepository) : ViewModel() {

    private var _userData = MutableLiveData<List<UserModal>>()
    var userData : LiveData<List<UserModal>> = _userData

    init {
        viewModelScope.launch {
            _userData.value = userRepository.getUserData()
        }
    }

}