package com.gibson.repository.sql;

import com.gibson.model.History;
import com.gibson.model.User;
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
public abstract class DBUserRepository {

    private static final String ID = "IDAppUser";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Pswrd";
    private static final String IS_ADMIN = "IsAdmin";
    private static final String ITEM_NAME = "ItemName";
    private static final String QUANTITY = "Quantity";
    private static final String DATE = "DateOfPurchase";
    private static final String PAYMENT_METHOD = "PaymentMethod";
    private static final String PRICE = "Price";

    private static final String CREATE_USER = "{ call spCreateAppUser(?, ?, ?, ?) }";
    private static final String SELECT_USERS = "{ call spSelectUsers }";
    private static final String SELECT_USER = "{ call spSelectUser(?) }";
    private static final String UPDATE_USER = "{ call spUpdateUser(?, ?, ?, ?) }";
    private static final String DELETE_USER = "{ call spDeleteUser(?) }";
    private static final String AUTHENTICATE = "{ call spAuthenticate(?, ?) }";
    private static final String USER_HISTORY = "{ call spSelectUserPurchaseHistory(?) }";

    public Optional<User> create(User user) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(CREATE_USER)) {
            stmt.registerOutParameter(ID, Types.INTEGER);
            stmt.setString(EMAIL, user.getEmail());
            stmt.setString(PASSWORD, user.getPassword());
            stmt.setBoolean(IS_ADMIN, user.isAdmin());
            stmt.executeUpdate();
            user.setId(stmt.getInt(1));
            return Optional.of(user);
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public Optional<User> findById(Integer id) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_USER)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(ID),
                            rs.getString(EMAIL),
                            rs.getString(PASSWORD),
                            rs.getBoolean(IS_ADMIN))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_USERS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt(ID),
                        rs.getString(EMAIL),
                        rs.getString(PASSWORD),
                        rs.getBoolean(IS_ADMIN)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public Optional<User> update(User user) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(UPDATE_USER)) {
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setBoolean(4, user.isAdmin());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(ID),
                            rs.getString(EMAIL),
                            rs.getString(PASSWORD),
                            rs.getBoolean(IS_ADMIN))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public void delete(User user) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(DELETE_USER)) {
            stmt.setInt(1, user.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteById(Integer id) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(DELETE_USER)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Optional<User> authenticate(String email, String password) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(AUTHENTICATE)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(ID),
                            rs.getString(EMAIL),
                            rs.getString(PASSWORD),
                            rs.getBoolean(IS_ADMIN))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public List<History> getUserPurchaseHistory(int userId) {
        List<History> history = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(USER_HISTORY)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    history.add(new History(
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
