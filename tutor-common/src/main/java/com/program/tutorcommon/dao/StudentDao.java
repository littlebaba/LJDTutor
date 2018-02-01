package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Li on 2018/2/1.
 */
public interface StudentDao extends JpaRepository<Student,Integer>,JpaSpecificationExecutor{

    Student findOne(Integer integer);

    List<Student> findAll();

    List<Student> findAll(Sort sort);
}
