package com.example.denchickslaziet


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
class InputViewModel : ViewModel(){
    private val _input = MutableStateFlow("")
    val input : StateFlow<String> = _input.asStateFlow()

    private val _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog.asStateFlow()

    fun onInputChange(value: String){
        _input.value = value
    }
    fun onConfirm(onValid: (Int) -> Unit){
        val number = _input.value.toIntOrNull()
        if (number == null || number < 1 || number > 1000){
            _showDialog.value = true
        }else{
            onValid(number)
        }
    }
    fun dismissDialog(){
        _showDialog.value = false
    }
}