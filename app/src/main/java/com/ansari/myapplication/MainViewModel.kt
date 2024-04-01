package com.ansari.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var count : Int = 0

    var myLiveData = MutableLiveData<String>("First Data")

    fun increment(){
        count++
    }

    fun dataChange(){
        myLiveData.value = "Second Data "
    }
}