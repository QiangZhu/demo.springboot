package com.fable.shiro.domain;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
@Entity
@Table(name = "t_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String rolename;

	@OneToMany(mappedBy = "role")
	private List<Permission> permissionList;

	@ManyToMany
	@JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
	private List<User> userList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Transactional
	public List<String> getPermissionsName(){
		List<String> permissionsName = new ArrayList<String>();
		List<Permission> permissions = getPermissionList();
		for (Permission permission : permissions){
			permissionsName.add(permission.getPermissionname());
		}
		return permissionsName;
	}
}
