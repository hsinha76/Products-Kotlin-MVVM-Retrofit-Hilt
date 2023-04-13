package com.hsdroid.products.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hsdroid.products.data.Products
import com.hsdroid.products.viewmodel.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {
    private lateinit var livedataList: MutableLiveData<List<Products>>

    init {
        livedataList = MutableLiveData()
    }

    fun callData(): MutableLiveData<List<Products>> {
        return livedataList
    }

    fun getData() {
        repository.makeAPICall(livedataList)
    }
}