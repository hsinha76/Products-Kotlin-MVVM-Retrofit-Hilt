package com.hsdroid.products.network

import com.hsdroid.products.data.Products
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("/products")
    fun getProducts() : Call<List<Products>>
}