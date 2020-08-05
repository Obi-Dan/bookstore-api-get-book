package com.hofferberts.bookstore.api.get.book

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GetBookController {

    val counter = AtomicLong()

    data class Greeting(val id: Long, val content: String)
    
    @GetMapping("/book")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

}