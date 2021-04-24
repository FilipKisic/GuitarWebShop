package com.gibson.services;

import com.gibson.model.History;
import com.gibson.model.User;
import com.gibson.repository.UserRepository;
import com.gibson.repository.sql.DBUserRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Filip Kisic
 */
public class UserService extends DBUserRepository implements UserRepository {

    @Override
    public Optional<User> create(User user) {
        return super.create(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<User> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<User> update(User user) {
        return super.update(user);
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public Optional<User> authenticate(String email, String password) {
        return super.authenticate(email, password);
    }
    
    @Override
    public List<History> getUserPurchaseHistory(int userId){
        return super.getUserPurchaseHistory(userId);
    }
}
