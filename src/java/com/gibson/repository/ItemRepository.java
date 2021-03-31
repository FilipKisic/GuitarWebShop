package com.gibson.repository;

import com.gibson.model.Item;
import java.util.List;

/**
 *
 * @author Filip Kisic
 */
public interface ItemRepository extends CrudRepository<Item, Integer> {
    List<Item> selectByCategory(int categoryId);
}
