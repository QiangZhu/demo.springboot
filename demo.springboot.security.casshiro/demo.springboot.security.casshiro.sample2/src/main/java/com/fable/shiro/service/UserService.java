package com.fable.shiro.service;

import com.fable.shiro.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public interface UserService {

	/**
	 * 根据用户名查询用户信息
	 */
	User findByUsername(String username);

	/**
	 * 查询所有的用户信息
	 */
	List<User> findAll();
}
