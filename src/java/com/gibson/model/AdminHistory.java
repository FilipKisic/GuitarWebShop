package com.gibson.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Filip Kisic
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminHistory {
    
    private Integer idUser;
    private String email;
    private String itemName;
    private Integer quantity;
    private LocalDateTime dateOfPurchase;
    private String paymentMethod;
    private Double price;
}
