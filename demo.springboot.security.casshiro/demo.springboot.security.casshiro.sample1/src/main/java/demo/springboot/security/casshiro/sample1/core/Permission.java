/**
 * 2017年3月21日
 * zq
 */
package demo.springboot.security.casshiro.sample1.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Package : demo.springboot.security.casshiro.sample1.core
 * 
 * @author YixinCapital -- zq
 *		   2017年3月21日 上午9:50:23
 *
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
    private Role role;// 一个权限对应一个角色

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

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permissionname=" + permissionname + ", role=" + role + "]";
	}
    
}
