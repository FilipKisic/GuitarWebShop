package com.gibson.services;

import com.gibson.model.Bill;
import com.gibson.model.Item;
import com.gibson.repository.BillRepository;
import com.gibson.repository.sql.DBBillRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Filip Kisic
 */
public class BillService extends DBBillRepository implements BillRepository {

    @Override
    public Optional<Bill> create(Bill bill) {
        return super.create(bill);
    }

    @Override
    public Optional<Bill> findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<Bill> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Bill> update(Bill bill) {
        return super.update(bill);
    }

    @Override
    public void delete(Bill bill) {
        super.delete(bill);
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void addItemToBill(int billId, int itemId, int quantity) {
        super.addItemToBill(billId, itemId, quantity);
    }

    @Override
    public List<Item> selectBillItems(int billId) {
        return super.selectBillItems(billId);
    }
}
