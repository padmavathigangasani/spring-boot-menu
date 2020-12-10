package com.example.hotel_menu_app.repository;

import com.example.hotel_menu_app.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Integer> {
}
