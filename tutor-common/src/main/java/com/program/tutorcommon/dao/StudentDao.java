package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Li on 2018/2/1.
 */
@Repository
@CacheConfig(cacheNames = "students")
public interface StudentDao extends JpaRepository<Student,Integer>,JpaSpecificationExecutor{

    @Override
    Student findOne(Integer integer);

    @Override
    @Cacheable
    List<Student> findAll();

    @Override
    List<Student> findAll(Sort sort);

    @Query(value = "select u from Student u where u.mobilePhone=?1")
    Object findStudentByMobile(String mobilePhone);

}
