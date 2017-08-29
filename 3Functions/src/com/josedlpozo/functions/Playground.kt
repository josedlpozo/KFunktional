package com.josedlpozo.functions

import java.net.URL

fun parseJSON(response: String) : Map<String, Any> = mapOf()
fun parseXML(response: String) : Map<String, Any> = mapOf()

fun data(url: String, parser: (String) -> Map<String, Any>) : Map<String, Any> = parser.invoke(URL(url).readText())

fun main(args: Array<String>) {
    data("http://www.josedlpozo.com", { parseJSON(it) })
    data("http://www.josedlpozo.com", { parseXML(it) })
}

