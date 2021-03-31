package com.gibson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Filip Kisic
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity{
    
    private int id;
}
