package com.example.translatetest.utils

import org.apache.hc.client5.http.classic.HttpClient
import org.apache.hc.client5.http.classic.methods.HttpGet
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse
import org.apache.hc.client5.http.impl.classic.HttpClients
import org.apache.hc.core5.http.HttpEntity
import org.apache.hc.core5.http.io.entity.EntityUtils
import java.net.URI

class NetworkDataQueryUtils {

     fun getResponseFromUrl(uri: URI):String{
        val client : CloseableHttpClient = HttpClients.createDefault()
        val request = HttpGet(uri)
        val respose : CloseableHttpResponse = client.execute(request)
        var response_entity_content = ""
        try {
            val entity : HttpEntity = respose.getEntity()
            response_entity_content = EntityUtils.toString(entity)
            EntityUtils.consume(entity)
        }finally {
            respose.close()
        }
        return response_entity_content
    }
}