package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Li on 2018/2/1.
 */
public interface SubjectDao extends JpaRepository<Subject,Integer> {
}
