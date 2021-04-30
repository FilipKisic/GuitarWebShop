package com.gibson.model;

import lombok.Getter;

/**
 *
 * @author Filip Kisic
 */
@Getter
public enum Category {
    LES_PAUL(1),
    SG(2),
    ES(3);
    
    private final int id;
    
    private Category(int id){
        this.id = id;
    }
}
