package com.example.covid19tracker

data class Response (
    val statewise: List<StatewiseItem>
)
data class StatewiseItem(
    val active: String?=null,
    val recovered: String? =null,
    val confirmed: String? =null,
    val deaths: String?=null,
    val deltaconfirmed: String? = null,
    val deltadeaths: String? =null,
    val deltarecovered: String? =null,
    val lastupdatedtime: String? =null,
    val statecode: String? = null,
    val state: String? =null
)
