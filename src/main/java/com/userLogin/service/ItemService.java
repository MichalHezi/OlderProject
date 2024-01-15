package com.userLogin.service;

import com.userLogin.model.Item;

import java.util.List;

public interface ItemService {
    Long createItem(Item item);
    String deleteItem(int id);
    String updatePriceOfItemById(double newPrice,int id);
    String updateStockById(int newStock, int id);
    List<Item> getAllItems();
}
