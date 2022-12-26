package com.example.dy.ui.screen.index

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "RouterViewModel"

// 数据Model
class RouterViewModel @Inject constructor(application: Application) : AndroidViewModel(application){

}