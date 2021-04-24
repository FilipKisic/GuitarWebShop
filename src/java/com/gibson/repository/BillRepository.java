package com.gibson.repository;

import com.gibson.model.Bill;
import com.gibson.model.Item;
import java.util.List;

/**
 *
 * @author Filip Kisic
 */
public interface BillRepository extends CrudRepository<Bill, Integer> {
    
    public void addItemToBill(int billId, int itemId, int quantity);

    //Maybe map <Bill, Item>
    public List<Item> selectBillItems(int billId);
}
