package com.gibson.repository;

import com.gibson.model.History;
import com.gibson.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Filip Kisic
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> authenticate(String email, String password);

    List<History> getUserPurchaseHistory(int userId);
}
