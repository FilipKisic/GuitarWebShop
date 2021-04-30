package com.gibson.repository.sql;

import com.gibson.model.ConnectionInfo;
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
public class DBInfoRepository {

    private static final String ID = "IDConnectionInfo";
    private static final String USERNAME = "Username";
    private static final String IP_ADDRESS = "IpAddress";
    private static final String TIME_OF_CONNECTION = "TimeOfConnection";

    private static final String CREATE = "{ call spCreateConnectionInfo(?, ?, ?, ?) }";
    private static final String SELECT_ONE = "{ call spSelectConnectionInfo(?) }";
    private static final String SELECT_ALL = "{ call spSelectConnectionInfos }";
    private static final String UPDATE = "{ call spUpdateConnectionInfo(?, ?, ?, ?) }";
    private static final String DELETE = "{ call spDeleteConnectionInfo(?) }";

    public Optional<ConnectionInfo> create(ConnectionInfo connectionInfo) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(CREATE)) {
            stmt.registerOutParameter(ID, Types.INTEGER);
            stmt.setString(USERNAME, connectionInfo.getUsername());
            stmt.setString(IP_ADDRESS, connectionInfo.getIpAddress());
            stmt.setTimestamp(TIME_OF_CONNECTION, Timestamp.valueOf(connectionInfo.getTimeOfConnection()));
            stmt.executeUpdate();
            connectionInfo.setId(stmt.getInt(1));
            return Optional.of(connectionInfo);
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public Optional<ConnectionInfo> findById(Integer id) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_ONE)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new ConnectionInfo(
                            rs.getInt(ID),
                            rs.getString(USERNAME),
                            rs.getString(IP_ADDRESS),
                            rs.getTimestamp(TIME_OF_CONNECTION).toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public List<ConnectionInfo> findAll() {
        List<ConnectionInfo> connectionInfos = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(SELECT_ALL);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                connectionInfos.add(new ConnectionInfo(
                        rs.getInt(ID),
                        rs.getString(USERNAME),
                        rs.getString(IP_ADDRESS),
                        rs.getTimestamp(TIME_OF_CONNECTION).toLocalDateTime()
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connectionInfos;
    }

    public Optional<ConnectionInfo> update(ConnectionInfo connectionInfo) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(UPDATE)) {
            stmt.registerOutParameter(ID, Types.INTEGER);
            stmt.setString(USERNAME, connectionInfo.getUsername());
            stmt.setString(IP_ADDRESS, connectionInfo.getIpAddress());
            stmt.setTimestamp(TIME_OF_CONNECTION, Timestamp.valueOf(connectionInfo.getTimeOfConnection()));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new ConnectionInfo(
                            rs.getInt(ID),
                            rs.getString(USERNAME),
                            rs.getString(IP_ADDRESS),
                            rs.getTimestamp(TIME_OF_CONNECTION).toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public void delete(ConnectionInfo connectionInfo) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(DELETE)) {
            stmt.setInt(1, connectionInfo.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteById(Integer id) {
        DataSource dataSource = DataSourceSingleton.getInstace();
        try (Connection connection = dataSource.getConnection();
                CallableStatement stmt = connection.prepareCall(DELETE)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBUserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
