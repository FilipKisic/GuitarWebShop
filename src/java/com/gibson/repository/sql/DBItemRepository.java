/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gibson.repository.sql;

import com.gibson.model.Item;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public abstract class DBItemRepository {

    private static final String ID = "IDItem";
    private static final String ITEM_NAME = "ItemName";
    private static final String ITEM_DESCRIPTION = "ItemDescription";
    private static final String PRICE = "Price";
    private static final String ITEM_IMAGE = "ItemImage";
    private static final String CATEGORY_ID = "CategoryID";

    private static final String CREATE_ITEM = "{ call spCreateItem(?, ?, ?, ?, ?, ?) }";
    private static final String SELECT_ITEMS = "{ call spSelectItems }";
    private static final String SELECT_ITEM = "{ call spSelectItem(?) }";
    private static final String UPDATE_ITEM = "{ call spUpdateItem(?, ?, ?, ?, ?, ?) }";
    private static final String DELETE_ITEM = "{ call spDeleteItem(?) }";
    private static final String SELECT_BY_CATEGORY = "{ call spSelectItemsFromCategory(?) }";

    public Optional<Item> create(Item item) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(CREATE_ITEM)) {
            stmt.registerOutParameter(ID, Types.INTEGER);
            stmt.setString(ITEM_NAME, item.getName());
            stmt.setString(ITEM_DESCRIPTION, item.getDescription());
            stmt.setDouble(PRICE, item.getPrice());
            stmt.setBytes(ITEM_IMAGE, item.getImage());
            stmt.setInt(CATEGORY_ID, item.getCategoryId());
            stmt.executeUpdate();
            item.setId(stmt.getInt(1));
            return Optional.of(item);
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public Optional<Item> findById(Integer id) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_ITEM)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Item(
                            rs.getInt(ID),
                            rs.getString(ITEM_NAME),
                            rs.getString(ITEM_DESCRIPTION),
                            rs.getDouble(PRICE),
                            rs.getBytes(ITEM_IMAGE),
                            rs.getInt(CATEGORY_ID))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_ITEMS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                items.add(new Item(
                        rs.getInt(ID),
                        rs.getString(ITEM_NAME),
                        rs.getString(ITEM_DESCRIPTION),
                        rs.getDouble(PRICE),
                        rs.getBytes(ITEM_IMAGE),
                        rs.getInt(CATEGORY_ID)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    public Optional<Item> update(Item item) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(UPDATE_ITEM)) {
            stmt.registerOutParameter(ID, Types.INTEGER);
            stmt.setString(ITEM_NAME, item.getName());
            stmt.setString(ITEM_DESCRIPTION, item.getDescription());
            stmt.setDouble(PRICE, item.getPrice());
            stmt.setBytes(ITEM_IMAGE, item.getImage());
            stmt.setInt(CATEGORY_ID, item.getCategoryId());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Item(
                            rs.getInt(ID),
                            rs.getString(ITEM_NAME),
                            rs.getString(ITEM_DESCRIPTION),
                            rs.getDouble(PRICE),
                            rs.getBytes(ITEM_IMAGE),
                            rs.getInt(CATEGORY_ID))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public void delete(Item item) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(DELETE_ITEM)) {
            stmt.setInt(1, item.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteById(Integer id) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(DELETE_ITEM)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Item> selectByCategory(Integer categoryId) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        List<Item> items = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_BY_CATEGORY)) {
            stmt.setInt(1, categoryId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    items.add(new Item(
                            rs.getInt(ID),
                            rs.getString(ITEM_NAME),
                            rs.getString(ITEM_DESCRIPTION),
                            rs.getDouble(PRICE),
                            rs.getBytes(ITEM_IMAGE),
                            rs.getInt(CATEGORY_ID))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }
}
