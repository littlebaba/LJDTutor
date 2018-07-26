package com.program.tutorcommon.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li on 2018/2/1.
 */
public class BaseServiceImpl<E extends JpaRepository,T> implements BaseService<T>{

    @Autowired
    public E repository;

    @Override
    public T findOne(int key) {
        return (T) repository.findOne(key);
    }

    @Override
    public T save(T entity) {
        return (T) repository.save(entity);
    }

    @Override
    public void delete(Object key) {
        repository.delete(key);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public long getCount() {
        return repository.count();
    }


}
