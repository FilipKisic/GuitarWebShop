package com.gibson.model;

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
public class User extends BaseEntity{
    
    private String email;
    private String password;
    private boolean isAdmin;

    public User(int id, String username, String password, boolean isAdmin) {
        super(id);
        this.email = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
