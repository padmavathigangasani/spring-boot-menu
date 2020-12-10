package com.example.hotel_menu_app.response;

import java.util.List;
import java.util.Objects;

public class MenuResponse {

    private Integer id;
    private String name;
    private double price;
    private List AlMenu;

    public MenuResponse(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public MenuResponse(List AlMenu) {
        this.AlMenu = AlMenu;
    }

    public MenuResponse() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuResponse that = (MenuResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(price,that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name,price);
    }

}
