package com.program.tutorcommon.dao;

import com.program.tutorcommon.entity.Teacher;
import com.program.tutorcommon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Li on 2018/2/14.
 */
public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor {
}
