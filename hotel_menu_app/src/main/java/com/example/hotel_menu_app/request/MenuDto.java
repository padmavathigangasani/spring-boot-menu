package com.example.hotel_menu_app.request;

public class MenuDto {
    private String menuName;
    private double price;

    public MenuDto(String menuName,double price) {
        this.menuName = menuName;
        this.price = price;
    }

    public MenuDto() {
    }

    public String getMenuName() {
        return menuName;
    }
    public double getPrice() {
        return price;
    }

}
