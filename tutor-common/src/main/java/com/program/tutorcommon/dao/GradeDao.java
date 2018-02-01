package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Li on 2018/2/1.
 */
public interface GradeDao extends JpaRepository<Grade,Integer> {
}
