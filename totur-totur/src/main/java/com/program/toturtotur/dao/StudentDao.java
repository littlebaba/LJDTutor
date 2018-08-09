package com.program.toturtotur.dao;

import com.program.toturtotur.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Li on 2018/2/1.
 */
@Repository
public interface StudentDao extends JpaSpecificationExecutor, JpaRepository<Student,Integer> {

    @Override
    Student findOne(Integer integer);

    @Override
    List<Student> findAll();

    @Override
    List<Student> findAll(Sort sort);

    @Query(value = "select u from Student u where u.mobilePhone=?1")
    Object findStudentByMobile(String mobilePhone);

}
