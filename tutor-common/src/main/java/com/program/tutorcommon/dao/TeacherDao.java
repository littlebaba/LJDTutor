package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Teacher;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Li on 2018/2/1.
 */
@Repository
@CacheConfig(cacheNames = "teachers")
public interface TeacherDao extends JpaRepository<Teacher,Integer>,JpaSpecificationExecutor {
    @Override
    Teacher findOne(Integer integer);

    @Override
    @Cacheable
    List<Teacher> findAll();

    @Override
    List<Teacher> findAll(Sort sort);
}
