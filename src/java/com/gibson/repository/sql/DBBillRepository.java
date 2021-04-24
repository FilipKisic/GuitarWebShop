/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gibson.repository.sql;

import com.gibson.model.Bill;
import com.gibson.model.Item;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Filip Kisic
 */
public abstract class DBBillRepository {

    private static final String ID = "IDBill";
    private static final String APP_USER_ID = "AppUserID";
    private static final String DATE_OF_PURCHASE = "DateOfPurchase";
    private static final String TOTAL_PRICE = "TotalPrice";
    private static final String PAYMENT_METHOD = "PaymentMethod";

    private static final String BILL_ID = "BillID";
    private static final String ITEM_ID = "ItemID";
    private static final String QUNATITY = "Quantity";

    private static final String CREATE_BILL = "{ call spCreateBill( ?, ?, ?, ?, ? ) }";
    private static final String SELECT_BILL = "{ call spSelectBill(?) }";
    private static final String SELECT_BILLS = "{ call spSelectBills }";
    private static final String UPDATE_BILL = "{ call spUpdateBill( ?, ?, ?, ?, ? ) }";
    private static final String DELETE_BILL = "{ call spDeleteBill(?) }";
    private static final String ADD_ITEM_TO_BILL = "{ call spAddItemToBill(?, ?, ?) }";
    private static final String SELECT_BILL_ITEMS = "{ call spSelectBillItems(?) }";

    public Optional<Bill> create(Bill bill) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(CREATE_BILL)) {
            stmt.registerOutParameter(ID, Types.INTEGER);
            stmt.setInt(APP_USER_ID, bill.getUserId());
            stmt.setTimestamp(DATE_OF_PURCHASE, Timestamp.valueOf(bill.getDateOfPurchase()));
            stmt.setDouble(TOTAL_PRICE, bill.getTotalPrice());
            stmt.setString(PAYMENT_METHOD, bill.getPaymentMethod());
            stmt.executeUpdate();
            bill.setId(stmt.getInt(1));
            return Optional.of(bill);
        } catch (SQLException ex) {
            Logger.getLogger(DBBillRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public Optional<Bill> findById(Integer id) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_BILL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Bill(
                            rs.getInt(ID),
                            rs.getInt(APP_USER_ID),
                            rs.getTimestamp(DATE_OF_PURCHASE).toLocalDateTime(),
                            rs.getDouble(TOTAL_PRICE),
                            rs.getString(PAYMENT_METHOD)
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public List<Bill> findAll() {
        List<Bill> bills = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_BILLS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                bills.add(new Bill(
                        rs.getInt(ID),
                        rs.getInt(APP_USER_ID),
                        rs.getTimestamp(DATE_OF_PURCHASE).toLocalDateTime(),
                        rs.getDouble(TOTAL_PRICE),
                        rs.getString(PAYMENT_METHOD)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }

    public Optional<Bill> update(Bill bill) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(UPDATE_BILL)) {
            stmt.registerOutParameter(ID, Types.INTEGER);
            stmt.setInt(APP_USER_ID, bill.getUserId());
            stmt.setTimestamp(DATE_OF_PURCHASE, Timestamp.valueOf(bill.getDateOfPurchase()));
            stmt.setDouble(TOTAL_PRICE, bill.getTotalPrice());
            stmt.setString(PAYMENT_METHOD, bill.getPaymentMethod());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Bill(
                            rs.getInt(ID),
                            rs.getInt(APP_USER_ID),
                            rs.getTimestamp(DATE_OF_PURCHASE).toLocalDateTime(),
                            rs.getDouble(TOTAL_PRICE),
                            rs.getString(PAYMENT_METHOD)
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public void delete(Bill item) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(DELETE_BILL)) {
            stmt.setInt(1, item.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteById(Integer id) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(DELETE_BILL)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addItemToBill(int billId, int itemId, int quantity) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(ADD_ITEM_TO_BILL)) {
            stmt.setInt(ITEM_ID, itemId);
            stmt.setInt(BILL_ID, billId);
            stmt.setInt(QUNATITY, quantity);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBBillRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Item> selectBillItems(int billId) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        List<Item> items = new ArrayList<Item>();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_BILL_ITEMS)) {
            stmt.setInt(BILL_ID, billId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    items.add(new Item(
                            rs.getInt(ID),
                            rs.getString("ItemName"),
                            rs.getString("ItemDescription"),
                            rs.getDouble("Price"),
                            rs.getBytes("ItemImage"),
                            rs.getInt("CategoryID")
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBillRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }
}
