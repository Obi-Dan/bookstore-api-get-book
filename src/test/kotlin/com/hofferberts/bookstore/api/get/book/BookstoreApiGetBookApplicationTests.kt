package com.hofferberts.bookstore.api.get.book

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@WebMvcTest(GetBookController::class)
class WebMockTest {
	@Autowired
	val mockMvc: MockMvc? = null

	@MockBean
	val service: GetBookService? = null

	@Test
	@Throws(Exception::class)
	fun greetingShouldReturnMessageFromService() {
		Mockito.`when`(service?.getBook("1234")).thenReturn(Book("1234", "Mock"))
		mockMvc!!.perform(MockMvcRequestBuilders.get("/books/1234"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk)
			.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.`is`("1234")))
	}
}