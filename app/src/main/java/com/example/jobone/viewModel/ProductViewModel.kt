package com.example.jobone.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobone.ApiInstance.apiService
import com.example.jobone.Product
import kotlinx.coroutines.launch

class ProductViewModel:ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        viewModelScope.launch {
            fetchProducts()

        }
    }


    private suspend fun fetchProducts() {
        try {
            val products = apiService.getProducts()
            _products.postValue(products)

        } catch (e: Exception){


        }

    }
}