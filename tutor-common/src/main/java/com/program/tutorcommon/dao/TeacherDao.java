package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Teacher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Li on 2018/2/1.
 */
public interface TeacherDao extends JpaRepository<Teacher,Integer>,JpaSpecificationExecutor {
    Teacher findOne(Integer integer);

    List<Teacher> findAll();

    List<Teacher> findAll(Sort sort);
}
