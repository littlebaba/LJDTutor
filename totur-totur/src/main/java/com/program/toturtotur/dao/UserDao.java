package com.program.toturtotur.dao;

import com.program.toturtotur.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Li on 2018/2/14.
 */
public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor {
    User findByUsername(String username);

    User findByEmail(String email);

}
