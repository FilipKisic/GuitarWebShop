package com.gibson.repository;

import com.gibson.model.User;
import java.util.Optional;

/**
 *
 * @author Filip Kisic
 */
public interface UserRepository extends CrudRepository<User, Integer>{
    Optional<User> authenticate(String email, String password);
}
