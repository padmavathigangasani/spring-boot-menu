package com.example.hotel_menu_app.service;

import com.example.hotel_menu_app.model.Menu;
import com.example.hotel_menu_app.repository.MenuRepository;
import com.example.hotel_menu_app.repository.MenuRepositoryTest;
import com.example.hotel_menu_app.request.MenuDto;
import com.example.hotel_menu_app.response.MenuResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceTest {


    @Mock //fake
    private MenuRepository menuRepository;

    private MenuService menuService;

    @Before
    public void setUp() {
        menuService = new MenuService(menuRepository);
    }

    @Test
    public void shouldCreateMenu() {
        // prepare
        MenuResponse response = new MenuResponse(1, "paneer",50.0);
        Menu menuWithId = new Menu( "paneer",50.0);
        Menu menu = new Menu("paneer",50);
        Mockito.when(menuRepository.save(any())).thenReturn(menuWithId);

        // act
        MenuResponse result = menuService.save(new MenuDto("paneer",50.0));

        // assert
        assertEquals(response.getName(), result.getName());
        verify(menuRepository).save(menu);
    }

    @Test
    public void shouldGetMenuById() {
        MenuResponse expected = new MenuResponse(1, "paneer",50.0);
        Menu menu = new Menu("paneer",50.0);
      //  menuRepository.save(menu);
        System.out.println(menu.toString());
        Mockito.when(menuRepository.findById(1)).thenReturn(Optional.of(menu));
       // MenuResponse result = menuService.save(new MenuDto("paneer",50.0));
       MenuResponse actual = menuService.getMenuById(1);

        assertEquals(expected, actual);
    }
}

