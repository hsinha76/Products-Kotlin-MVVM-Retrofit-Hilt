package com.hsdroid.products.viewmodel.repository

import androidx.lifecycle.MutableLiveData
import com.hsdroid.products.data.Products
import com.hsdroid.products.network.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiInterface: APIInterface) {
    fun makeAPICall(livedata : MutableLiveData<List<Products>>) {
        val call: Call<List<Products>> = apiInterface.getProducts()
        call.enqueue(object : Callback<List<Products>> {
            override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
                livedata.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                livedata.postValue(null)
            }

        })
    }
}