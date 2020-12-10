package com.example.hotel_menu_app.service;

import com.example.hotel_menu_app.exception.MenuNotFoundException;
import com.example.hotel_menu_app.model.Menu;
import com.example.hotel_menu_app.repository.MenuRepository;
import com.example.hotel_menu_app.request.MenuDto;
import com.example.hotel_menu_app.response.MenuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;


    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public MenuResponse save(MenuDto menuDto) {
        Menu savedMenu = menuRepository.save(new Menu(menuDto.getMenuName(),menuDto.getPrice()));
        return new MenuResponse(savedMenu.getId(), savedMenu.getName(),savedMenu.getPrice());
//        policyService.getPolicies(customerId)
    }

    public MenuResponse getMenuById(Integer id) {
        Menu savedMenu = menuRepository.findById(id).orElseThrow(() -> new MenuNotFoundException());
        return new MenuResponse(savedMenu.getId(), savedMenu.getName(), savedMenu.getPrice());
    }

    public MenuResponse getAllMenu() {
        List savedMenu = menuRepository.findAll();
        return new MenuResponse(savedMenu);
    }

}
