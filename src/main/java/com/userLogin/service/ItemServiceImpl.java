package com.userLogin.service;

import com.userLogin.model.Item;
import com.userLogin.repository.ItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepositoryImpl itemRepository;
    @Override
    public Long createItem(Item item) {
        return itemRepository.createItem(item);
    }

    @Override
    public String deleteItem(int id) {
        return itemRepository.deleteItem(id);
    }

    @Override
    public String updatePriceOfItemById(double newPrice,int id) {
        return itemRepository.updatePriceOfItemById(newPrice, id);
    }

    @Override
    public String updateStockById(int newStock, int id) {
        return itemRepository.updateStockById(newStock, id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }
}
