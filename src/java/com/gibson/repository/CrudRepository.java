package com.gibson.repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Filip Kisic
 */
public interface CrudRepository<T, ID> {

    Optional<T> create(T object);

    Optional<T> findById(ID id);

    List<T> findAll();

    Optional<T> update(T object);

    void delete(T object);

    void deleteById(ID id);
}
