package com.singh.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i ORDER BY i.dateUpdated DESC")
@NamedQuery(name = "Inventory.clearList", query = "DELETE FROM Inventory")
@NamedQuery(name = "Inventory.getByName", query = "SELECT i from Inventory i where i.name = :name")
public class Inventory implements Comparable<Inventory>, Serializable {

    @Id
    @SequenceGenerator(name = "inventory_sequence", sequenceName = "inventory_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_sequence")
    private Long id;
    private String name;
    private String sport;
    private Integer quantity;
    private BigDecimal price;
    private Date dateUpdated;

    @PrePersist
    @PreUpdate
    public void createdOrUpdateAt() {
        dateUpdated = new Date();
    }

    @Override
    public int compareTo(Inventory i) {
        return dateUpdated.compareTo(i.dateUpdated);
    }
}

