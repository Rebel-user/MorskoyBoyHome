package uz.msu.kotlin

import io.vertx.core.AbstractVerticle

class Server : AbstractVerticle() {
    override fun start() {
        vertx.createHttpServer()
            .requestHandler {req ->
                val a = req.getParam("a")
                val b = req.getParam("b")
                req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from R : $a + $b = ${a.toInt() + b.toInt()}")
            }.listen(80)
    }
}