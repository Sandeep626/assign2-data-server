package com.singh.inventory;

import com.singh.entity.Inventory;

import java.util.List;

public interface InventoryService {

    void clearList();
    List<Inventory> getInventoryList();
    void addToList(Inventory inventory);
    void removeFromList(Inventory inventory);
    Inventory getInventoryById(Long id);//
}
