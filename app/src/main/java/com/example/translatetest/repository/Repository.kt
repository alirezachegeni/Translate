package com.example.translatetest.repository

import com.example.translatetest.data.NetworkDataSource
import com.example.translatetest.model.Model
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(
    private val networkDataSource: NetworkDataSource
) {
    suspend fun getTranslate(query: String,translate:String): Model {
        val model: Model
        withContext(Dispatchers.IO) {
        model = networkDataSource.getTrans(query,translate)
    }
    return model
}}