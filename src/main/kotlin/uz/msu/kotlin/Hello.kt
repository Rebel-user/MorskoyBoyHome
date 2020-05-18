package uz.msu.kotlin

import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient

fun main(args: Array<String>) {
    println("Hello, World")

     val vertx = Vertx.vertx()
     vertx.deployVerticle(Server())

    var canWork = true
    var client = WebClient.create(vertx)
    while(canWork) {
        val (a,b) = readLine()!!.split(" ") //schest s konsoli


        // Send a GET request
        client
            .get("localhost/?a=$a&b=$b") //obrasheniye k serveru
            .send{ ar ->
            if (ar.succeeded()) {  //esli server otvetil
                // Obtain response
                var response = ar.result()

                println("Received: ${response.body()}") //otvet1
            }
        }
    }
}

