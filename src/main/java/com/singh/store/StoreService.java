package com.singh.store;

import com.singh.entity.Store;

import java.util.List;

public interface StoreService {
    List<Store> getAllStores();

    Store getStoreById(Long id);

    void addStore(Store store);

    void updateStore(Long id, List<Long> inventoryIds);
}
