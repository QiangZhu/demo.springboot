package com.fable.shiro.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
@Entity
@Table(name = "t_permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String permissionname;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermissionname() {
		return permissionname;
	}

	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
