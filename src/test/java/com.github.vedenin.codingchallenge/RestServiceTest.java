package com.github.vedenin.codingchallenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by slava on 16.02.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkUserGetRequest() throws Exception {
        mockMvc.perform(post("/register")
                .param("userName", "6")
                .param("password", "20")
                .param("firstName", "20")
                .param("lastName", "20")
                .param("email", "test@test.com")
                .param("dataOfBirth", "20")
                .param("zipCode", "20")
                .param("city", "20")
                .param("country", "20")
        ).andExpect(status().isOk());
        mockMvc.perform(post("/login")
                .param("username", "6")
                .param("password", "20")
        ).andExpect(status().isOk());

        this.mockMvc.perform(get("/rest/user").with(user("6").password("20"))).andExpect(status().is(401));
        this.mockMvc.perform(get("/rest/user?access_key=sg435jklj").with(user("6").password("20"))).andExpect(status().isOk());
    }

    @Test
    public void checkErrorGetRequest() throws Exception {
        mockMvc.perform(post("/register")
                .param("userName", "6")
                .param("password", "20")
                .param("firstName", "20")
                .param("lastName", "20")
                .param("email", "test@test.com")
                .param("dataOfBirth", "20")
                .param("zipCode", "20")
                .param("city", "20")
                .param("country", "20")
        ).andExpect(status().isOk());
        mockMvc.perform(post("/login")
                .param("username", "6")
                .param("password", "20")
        ).andExpect(status().isOk());

        this.mockMvc.perform(get("/rest/error").with(user("6").password("20"))).andExpect(status().is(401));
        this.mockMvc.perform(get("/rest/error?access_key=sg435jklj").with(user("6").password("20"))).andExpect(status().isOk());
    }
}
