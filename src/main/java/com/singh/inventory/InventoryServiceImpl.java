package com.singh.inventory;
import com.singh.entity.Inventory;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote(InventoryService.class)
public class InventoryServiceImpl implements InventoryService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void clearList() {
        Query deleteFromInventory = em.createNamedQuery("Inventory.clearList");
        deleteFromInventory.executeUpdate();
    }

    @Override
    public List<Inventory> getInventoryList() {
        return em.createNamedQuery("Inventory.findAll", Inventory.class).getResultList();
    }

    @Override
    public void addToList(Inventory inventory) {
        em.persist(inventory);
    }

    @Override
    public void removeFromList(Inventory inventory) {
        Inventory item = em.createNamedQuery("Inventory.getByName", Inventory.class)
                .setParameter("name", inventory.getName()).getSingleResult();
        em.remove(item);
    }

    @Override
    public Inventory getInventoryById(Long id) {
        return em.find(Inventory.class, id);
    }
}

