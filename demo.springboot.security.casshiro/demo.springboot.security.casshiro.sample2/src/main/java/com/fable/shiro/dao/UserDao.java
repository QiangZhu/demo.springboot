package com.fable.shiro.dao;

import com.fable.shiro.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public interface UserDao extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findByUsername(@Param("username") String username);
}
