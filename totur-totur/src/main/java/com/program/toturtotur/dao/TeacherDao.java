package com.program.toturtotur.dao;

import com.program.toturtotur.entity.Teacher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Li on 2018/2/1.
 */
@Repository
public interface TeacherDao extends JpaRepository<Teacher,Integer>,JpaSpecificationExecutor {
    @Override
    Teacher findOne(Integer integer);

    @Override
    List<Teacher> findAll();

    @Override
    List<Teacher> findAll(Sort sort);
}
