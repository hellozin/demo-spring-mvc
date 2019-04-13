package me.hellozin.demospringmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MappingPracticeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getTest() throws Exception {
        mockMvc.perform(
                get("/events"))
                .andExpect(status().isOk())
                .andExpect(content().string("events"));

        for (int i = 1; i < 10; i++) {
            mockMvc.perform(
                    get("/events/" + i))
                    .andExpect(status().isOk())
                    .andExpect(content().string("events" + i));
        }
    }

    @Test
    public void postTest() throws Exception {
        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_XML)
        )
                .andExpect(status().isUnsupportedMediaType());
    }

}