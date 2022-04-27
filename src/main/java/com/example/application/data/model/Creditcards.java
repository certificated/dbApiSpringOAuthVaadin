package com.example.application.data.model;

import java.util.List;

public class Creditcards {

    private int totalItems;

    private List<Creditcard> items;

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Creditcard> getItems() {
        return items;
    }

    public void setItems(List<Creditcard> items) {
        this.items = items;
    }
}
