package com.program.tutorcommon.base;

import java.util.List;

/**
 * @author Li on 2018/2/1.
 */
public interface BaseService<T> {

    T findOne(int key);

    T save(T entity);

    void delete(Object key);

    List<T> findAll();

}
