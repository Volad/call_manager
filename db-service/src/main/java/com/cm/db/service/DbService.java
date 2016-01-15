
/**
 * 
 */
package com.cm.db.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface DbService<T, ID extends Serializable> {
    List<T> findAll();

    T save(T entity);

    Iterable<T> save(Iterable<T> entities);

    void delete(ID id);

    T findById(ID id);

    List<T> findByIds(Iterable<ID> ids);

    JpaRepository<T, ID> getRepository();

}
