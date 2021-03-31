package com.gibson.model;

/**
 *
 * @author Filip Kisic
 */
public enum Category {
    LES_PAUL(1),
    SG(2),
    ES(3);
    
    private final int id;
    
    private Category(int id){
        this.id = id;
    }
}
