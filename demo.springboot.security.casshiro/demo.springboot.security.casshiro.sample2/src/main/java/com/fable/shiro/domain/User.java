package com.fable.shiro.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
@Entity
@Table(name = "t_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "用户名不能为空")
	private String username;

	@NotEmpty(message = "密码不能为空")
	private String password;

	@ManyToMany
	@JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private List<Role> roleList;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@Transactional
	public Set<String> getRolesName(){
		List<Role> roles = getRoleList();
		Set<String> rolesName = new HashSet<String>();
		for (Role role : roles) {
			rolesName.add(role.getRolename());
		}
		return rolesName;
	}
}
