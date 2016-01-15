
/**
 * 
 */
package com.cm.db.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public abstract class DbServiceAbstract<T, ID extends Serializable> implements DbService<T, ID> {

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public Iterable<T> save(Iterable<T> entities) {
        return getRepository().save(entities);
    }

    @Override
    public void delete(ID id) {
        getRepository().delete(id);
    }

    @Override
    public T findById(ID id) {
        return getRepository().findOne(id);
    }

    @Override
    public List<T> findByIds(Iterable<ID> ids) {
        return getRepository().findAll(ids);
    }

}
