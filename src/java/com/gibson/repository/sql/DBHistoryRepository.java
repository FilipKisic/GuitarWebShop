/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gibson.repository.sql;

import com.gibson.model.AdminHistory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Filip Kisic
 */
public abstract class DBHistoryRepository {

    private static final String ID = "IDAppUser";
    private static final String EMAIL = "Email";
    private static final String ITEM_NAME = "ItemName";
    private static final String QUANTITY = "Quantity";
    private static final String DATE = "DateOfPurchase";
    private static final String PAYMENT_METHOD = "PaymentMethod";
    private static final String PRICE = "Price";

    private static final String ALL_HISTORY = "{ call spSelectAllPurchaseHistory }";
    private static final String ALL_HISTORY_BY_EMAIL = "{ call spSelectAllPurchaseHistoryByEmail(?) }";
    private static final String ALL_HISTORY_BY_DATE = " { call spSelectAllPurchaseHistoryByDate(?, ?) }";
    private static final String ALL_HISTORY_BY_EMAIL_AND_DATE = "{ call spSelectAllPurchaseHistoryByEmailAndDate (?, ?, ?) }";

    public List<AdminHistory> findAll() {
        List<AdminHistory> history = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(ALL_HISTORY);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                history.add(new AdminHistory(
                        rs.getInt(ID),
                        rs.getString(EMAIL),
                        rs.getString(ITEM_NAME),
                        rs.getInt(QUANTITY),
                        rs.getTimestamp(DATE).toLocalDateTime(),
                        rs.getString(PAYMENT_METHOD),
                        rs.getDouble(PRICE)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return history;
    }

    public List<AdminHistory> findAllByEmail(String email) {
        List<AdminHistory> history = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(ALL_HISTORY_BY_EMAIL)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    history.add(new AdminHistory(
                            rs.getInt(ID),
                            rs.getString(EMAIL),
                            rs.getString(ITEM_NAME),
                            rs.getInt(QUANTITY),
                            rs.getTimestamp(DATE).toLocalDateTime(),
                            rs.getString(PAYMENT_METHOD),
                            rs.getDouble(PRICE)
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return history;
    }

    public List<AdminHistory> findAllByDate(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<AdminHistory> history = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(ALL_HISTORY_BY_DATE)) {
            stmt.setTimestamp(1, Timestamp.valueOf(dateFrom));
            stmt.setTimestamp(2, Timestamp.valueOf(dateTo));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    history.add(new AdminHistory(
                            rs.getInt(ID),
                            rs.getString(EMAIL),
                            rs.getString(ITEM_NAME),
                            rs.getInt(QUANTITY),
                            rs.getTimestamp(DATE).toLocalDateTime(),
                            rs.getString(PAYMENT_METHOD),
                            rs.getDouble(PRICE)
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return history;
    }

    public List<AdminHistory> findAllByEmailAndDate(String email, LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<AdminHistory> history = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(ALL_HISTORY_BY_EMAIL_AND_DATE)) {
            stmt.setString(1, email);
            stmt.setTimestamp(2, Timestamp.valueOf(dateFrom));
            stmt.setTimestamp(3, Timestamp.valueOf(dateTo));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    history.add(new AdminHistory(
                            rs.getInt(ID),
                            rs.getString(EMAIL),
                            rs.getString(ITEM_NAME),
                            rs.getInt(QUANTITY),
                            rs.getTimestamp(DATE).toLocalDateTime(),
                            rs.getString(PAYMENT_METHOD),
                            rs.getDouble(PRICE)
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return history;
    }
}
