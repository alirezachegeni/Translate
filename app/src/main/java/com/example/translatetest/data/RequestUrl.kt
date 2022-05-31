package com.example.translatetest.data

import java.net.URI

object RequestUrl {
    fun getSearchDataGoogle(query: String,translate:String): URI {
           return URI("https://one-api.ir/translate/?token=856347:62266451375266.08269888&action=google&lang=$translate&q=${query}")

    }
}