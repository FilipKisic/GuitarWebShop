package com.gibson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Filip Kisic
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity{
   
    private String name;
    private String description;
    private double price;
    private byte[] image;
    private int categoryId;
    private String base64Image;

    public Item(int id, String name, String description, double price, byte[] image, int categoryId) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categoryId = categoryId;
    }
}
