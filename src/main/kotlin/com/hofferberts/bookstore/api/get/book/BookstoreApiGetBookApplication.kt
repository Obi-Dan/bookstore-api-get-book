package com.hofferberts.bookstore.api.get.book

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*


data class Book(val id: String, val title: String)

@Service
class GetBookService {
	fun getBook(id: String): Book {
		return Book(id, "Book Title 1")
	}
}

@RestController
class GetBookController(val service: GetBookService) {
	@RequestMapping("/books/{id}")
	@ResponseBody
	fun getBook(@PathVariable id: String) = service.getBook(id)
}

@SpringBootApplication
class BookstoreApiGetBookApplication {
}

fun main(args: Array<String>) {
	runApplication<BookstoreApiGetBookApplication>(*args)
}