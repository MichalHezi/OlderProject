package com.userLogin.controller;

import com.userLogin.model.Item;
import com.userLogin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/public/item")
public class ItemController {
    @Autowired
    ItemService itemService;


    @PostMapping
    public Long createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }
    @DeleteMapping
    public String deleteItem(@RequestParam int id){
        itemService.deleteItem(id);
        return "Item deleted";
    }
    @PutMapping("/price")
    public String updatePriceOfItemById(@RequestBody Item item){
        if (item.getId() == 0 || item.getPrice() == 0){
            return "Can't change stuff to 0";
        }else{
            return itemService.updatePriceOfItemById(item.getPrice(), item.getId());
        }
    }
    @PutMapping("/stock")
    public String updateStockById(@RequestBody Item item){
        if (item.getId() == 0 || item.getStock() == 0){
            return "Can't change stuff to 0";
        }else{
            return itemService.updateStockById(item.getStock(), item.getId());
        }
    }
    @GetMapping(value = "/all")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
}
