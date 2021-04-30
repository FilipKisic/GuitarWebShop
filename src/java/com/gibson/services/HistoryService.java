package com.gibson.services;

import com.gibson.model.AdminHistory;
import com.gibson.repository.HistoryRepository;
import com.gibson.repository.sql.DBHistoryRepository;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Filip Kisic
 */
public class HistoryService extends DBHistoryRepository implements HistoryRepository{

    @Override
    public List<AdminHistory> findAllByEmailAndDate(String email, LocalDateTime dateFrom, LocalDateTime dateTo) {
        return super.findAllByEmailAndDate(email, dateFrom, dateTo);
    }

    @Override
    public List<AdminHistory> findAllByDate(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return super.findAllByDate(dateFrom, dateTo);
    }

    @Override
    public List<AdminHistory> findAllByEmail(String email) {
        return super.findAllByEmail(email);
    }

    @Override
    public List<AdminHistory> findAll() {
        return super.findAll();
    }
    
}
