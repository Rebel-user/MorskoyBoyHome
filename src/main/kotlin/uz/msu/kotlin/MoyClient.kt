package uz.msu.kotlin

import io.vertx.ext.web.client.WebClient

    class Client : io.vertx.core.AbstractVerticle()  {
        override fun start() {

            var client = WebClient.create(vertx)

            client.get(80, "localhost", "/") //mojno ip druga - localhost
                .send({ ar ->
                if (ar.succeeded()) {
                    var response = ar.result()   //otvet prixodit na response
                    println("Got HTTP response with status ${response.statusCode()} with data ${response.body().toString("ISO-8859-1")}")
                } else {
                    ar.cause().printStackTrace()
                }
            })
        }
    }
