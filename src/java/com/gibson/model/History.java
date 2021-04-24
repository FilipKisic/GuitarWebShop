/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gibson.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Filip Kisic
 */
@Data
@AllArgsConstructor
public class History {

    private final String itemName;
    private final Integer quantity;
    private final LocalDateTime dateOfPurchase;
    private final String paymentMethod;
    private final Double price;
}
