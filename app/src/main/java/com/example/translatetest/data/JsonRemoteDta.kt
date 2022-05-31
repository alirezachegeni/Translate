package com.example.translatetest.data

import com.example.translatetest.model.Model
import org.json.JSONObject

class JsonRemoteDta {
    fun getTranslate(response:String): Model {
        val baseJson = JSONObject(response)
        val result = baseJson.getString("result")

     return Model(translate = result)
    }
}