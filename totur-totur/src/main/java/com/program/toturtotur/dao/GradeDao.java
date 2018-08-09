package com.program.toturtotur.dao;

import com.program.toturtotur.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Li on 2018/2/1.
 */
@Repository
public interface GradeDao extends JpaRepository<Grade,Integer> {
}
