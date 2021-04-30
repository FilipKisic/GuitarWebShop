package com.gibson.services;

import com.gibson.model.ConnectionInfo;
import com.gibson.repository.InfoRepository;
import com.gibson.repository.sql.DBInfoRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Filip Kisic
 */
public class InfoService extends DBInfoRepository implements InfoRepository {

    @Override
    public Optional<ConnectionInfo> create(ConnectionInfo connectionInfo) {
        return super.create(connectionInfo);
    }

    @Override
    public Optional<ConnectionInfo> findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<ConnectionInfo> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<ConnectionInfo> update(ConnectionInfo connectionInfo) {
        return super.update(connectionInfo);
    }

    @Override
    public void delete(ConnectionInfo connectionInfo) {
        super.delete(connectionInfo);
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }
}
