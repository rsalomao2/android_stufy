package com.salomao.androidstury.network

import com.google.gson.annotations.SerializedName

//"id": 1,
//"name": "Leanne Graham",
//"username": "Bret",
//"email": "Sincere@april.biz",
//"address": {
//    "street": "Kulas Light",
//    "suite": "Apt. 556",
//    "city": "Gwenborough",
//    "zipcode": "92998-3874",
//    "geo": {
//        "lat": "-37.3159",
//        "lng": "81.1496"
//    }
//},
//"phone": "1-770-736-8031 x56442",
//"website": "hildegard.org",
//"company": {
//    "name": "Romaguera-Crona",
//    "catchPhrase": "Multi-layered client-server neural-net",
//    "bs": "harness real-time e-markets"
//}


data class UserNetwork(
    val id: Int,
    val name: String,
    @SerializedName("username") val username: String,
    val email: String,
    val website: String,
    val address: AddressNetwork
)

data class AddressNetwork(
    val street: String,
    val city: String,
    val zipcode: String,
    val geo: GeoNetwork
)

data class GeoNetwork(
    val lat: String,
    val lng: String,
)
