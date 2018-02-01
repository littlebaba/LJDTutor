package com.program.tutorcommon.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Li on 2018/2/1.
 */
public class BaseServiceImpl<E extends JpaRepository,T> implements BaseService<T>{

    @Autowired
    protected E repository;

    public T findOne(int key) {
        return (T) repository.findOne(key);
    }

    public T save(T entity) {
        return (T) repository.save(entity);
    }

    public void delete(Object key) {
        repository.delete(key);
    }

    public List<T> findAll() {
        return repository.findAll();
    }
}
