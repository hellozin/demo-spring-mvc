package me.hellozin.demospringmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/hello/ahn"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello ahn"));

        /* RFD Attack 방지 */
        mockMvc.perform(get("/hell o/ahn.html"))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/json").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo (print())
                .andExpect(status().isOk());
    }

    @Test
    public void headerTest() throws Exception {
        mockMvc.perform(get("/header").header(HttpHeaders.AUTHORIZATION, "key"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void customAnnotationTest() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}