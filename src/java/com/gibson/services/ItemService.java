package com.gibson.services;

import com.gibson.model.Item;
import com.gibson.repository.ItemRepository;
import com.gibson.repository.sql.DBItemRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Filip Kisic
 */
public class ItemService extends DBItemRepository implements ItemRepository{

    @Override
    public Optional<Item> create(Item item) {
        return super.create(item);
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Item> update(Item item) {
        return super.update(item);
    }

    @Override
    public void delete(Item item) {
        super.delete(item);
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public List<Item> selectByCategory(int categoryId) {
        return super.selectByCategory(categoryId);
    }
    
}
