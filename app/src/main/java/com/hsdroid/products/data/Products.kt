package com.hsdroid.products.data

data class Products(val image: String = "",
                    val price: Double = 0.0,
                    val rating: Rating,
                    val description: String = "",
                    val id: Int = 0,
                    var title: String = "",
                    val category: String = "")