package me.hellozin.demospringmvc;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
// @WebMvcTest /* Web 과 관련된 계층만 Test 하는 annotation */ /* @Component 는 Web 과 관련된 설정이 아니여서 Formatter 테스트 깨짐 */
@SpringBootTest /* 전체 테스트를 통해 Web 과 관련된 빈 뿐만 아니라 모든 Annotation 추가 대신 Mock 등록 안됨 */
@AutoConfigureMockMvc /* 이 Annotation 을 통해 Mock 관련 Bean 주입 */
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void hello() throws Exception {
        Person person = new Person();
        person.setName("hellozin");
        Person savedPerson = personRepository.save(person);

        this.mockMvc.perform(get("/hello")
                    .param("id", savedPerson.getId().toString()))
                .andDo(print())
                .andExpect(content().string("hello hellozin"))
        ;
    }

    @Test
    public void resourceHandler() throws Exception {
        this.mockMvc.perform(get("/sample/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Hello Sample")))
                .andExpect(header().exists(HttpHeaders.CACHE_CONTROL))
        ;
    }
}