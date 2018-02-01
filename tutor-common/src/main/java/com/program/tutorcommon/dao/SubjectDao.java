package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Li on 2018/2/1.
 */
@Repository
public interface SubjectDao extends JpaRepository<Subject,Integer> {
}
