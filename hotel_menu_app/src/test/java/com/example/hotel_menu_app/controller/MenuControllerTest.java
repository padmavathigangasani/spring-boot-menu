package com.example.hotel_menu_app.controller;

import com.example.hotel_menu_app.request.MenuDto;
import com.example.hotel_menu_app.service.MenuService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class MenuControllerTest {
    @MockBean
    private MenuService menuService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSaveMenu() throws Exception {
        when(menuService.save(new MenuDto("thoughtworks",0.0))).thenReturn(null);

        // assert on data
        mockMvc.perform(post("/menu")
                .content("{\"menuName\": \"price\"}")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }


}
