package com.example.hotel_menu_app.controller;


import com.example.hotel_menu_app.model.Menu;
import com.example.hotel_menu_app.request.MenuDto;
import com.example.hotel_menu_app.service.MenuService;
import com.example.hotel_menu_app.response.MenuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<MenuResponse> createCustomer(@RequestBody MenuDto menuDto) throws URISyntaxException {
        System.out.println(menuDto.getMenuName());
        return ResponseEntity.created(new URI("/menu")).body(menuService.save(menuDto));
    }

    public MenuResponse retrieveAllMenu() {
        return menuService.getAllMenu();
    }
    /*@RequestMapping("/menu")
    public String retrieveMenu(@PathVariable("name") String name) {
        return welcomeService.getMessage(name);
    }*/
}
