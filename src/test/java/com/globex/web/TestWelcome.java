package com.globex.web;

import com.globex.web.config.SpringConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/testing.html#integration-testing-annotations-junit-jupiter
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringConfig.class)
//@SpringJUnitWebConfig(SpringConfig.class)
public class TestWelcome {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webAppContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    @Test
    public void testWelcome() throws Exception {

        this.mockMvc.perform(
                get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/WEB-INF/views/index.jsp"))
                .andExpect(model().attribute("msg", "we're not evil"));
        // testing fix
    }

    @Test
    public void testAbc() {
        assertEquals(3, 1 + 1 + 1);
    }
    
    @Test 
    public void testApple() { 
        assertEquals("apple","apple");  
    }
    
    @Test 
    public void testBanana() { 
        assertEquals("banana","banana");  
    }
    
    @Test 
    public void testCherry() { 
        assertEquals("cherry","cherry");  
    }
    @Test 
    public void testAlphabets1() { 
        assertEquals("abc","abc");  
    }
    
    @Test 
    public void testAlphabets2() { 
        assertEquals("def","def");  
    }
    
    @Test 
    public void testAlphabets3() { 
        assertEquals("hijk","hijk");  
    }    
}
