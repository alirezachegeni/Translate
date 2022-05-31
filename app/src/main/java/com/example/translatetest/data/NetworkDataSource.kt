package com.example.translatetest.data

import com.example.translatetest.model.Model
import com.example.translatetest.utils.NetworkDataQueryUtils

class NetworkDataSource {
    private val requestUrl by lazy{ RequestUrl}
    private val networkQuery by lazy { NetworkDataQueryUtils() }
    private val jsonRemoteData by lazy { JsonRemoteDta()}

    fun getTrans(query:String,translate:String): Model {
        val requestUrl = requestUrl.getSearchDataGoogle(query,translate)
        val response =networkQuery.getResponseFromUrl(requestUrl)
        return jsonRemoteData.getTranslate(response)
    }

}