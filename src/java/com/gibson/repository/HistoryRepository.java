/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gibson.repository;

import com.gibson.model.AdminHistory;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Filip Kisic
 */
public interface HistoryRepository {

    List<AdminHistory> findAll();
    
    List<AdminHistory> findAllByEmail(String email);
    
    List<AdminHistory> findAllByDate(LocalDateTime dateFrom, LocalDateTime dateTo);
    
    List<AdminHistory> findAllByEmailAndDate(String email, LocalDateTime dateFrom, LocalDateTime dateTo);
}
