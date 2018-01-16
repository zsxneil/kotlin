package com.my.springboot

import com.my.springboot.controller.GreetingController
import com.my.springboot.model.Greeting
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultHandler
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@WebMvcTest(GreetingController::class)
//@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private var mvc:MockMvc? = null

	@Test
	fun contextLoads() {
	}

    @Test
    fun indexTest() {
        mvc!!.perform(MockMvcRequestBuilders
                    .get("/index")
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().json("{\"msg\":\"success\",\"greeting\":{\"id\":1,\"content\":\"this is greet\"},\"status\":true}"))

    }

    @Test
    fun postTest() {

        mvc!!.perform(MockMvcRequestBuilders
                    .post("/show")
                    .header("content-type",MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(Greeting(1,"content").toString())
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                //.andExpect(MockMvcResultMatchers.content().json(reqMap.toString()))
    }

}
