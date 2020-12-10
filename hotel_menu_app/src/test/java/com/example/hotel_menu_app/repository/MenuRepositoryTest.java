package com.example.hotel_menu_app.repository;

import com.example.hotel_menu_app.HotelMenuAppApplication;
import com.example.hotel_menu_app.model.Menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void shouldSaveMenu() {
        Menu menu = new Menu("menu1", 5.0);
        menuRepository.save(menu);
        assertEquals(1, menuRepository.findAll().size());
    }

    @Test
    public void shouldFetchPriceByMenuName() {
        Menu menu = new Menu("menu1", 5.0);
        menuRepository.save(menu);
        assertEquals(Optional.of(menu), menuRepository.findById(1));

    }

}
