/**
 * 2017年3月21日
 * zq
 */
package demo.springboot.security.casshiro.sample1.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Package : demo.springboot.security.casshiro.sample1.core
 * 
 * @author YixinCapital -- zq 2017年3月21日 上午9:47:03
 *
 */
@Entity
@Table(name = "t_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rolename;
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<Permission> permissionList;// 一个角色对应多个权限
	@ManyToMany
	@JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private List<User> userList;// 一个角色对应多个用户

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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	@Transient
	public List<String> getPermissionsName() {
		List<String> list = new ArrayList<String>();
		List<Permission> perlist = getPermissionList();
		for (Permission per : perlist) {
			list.add(per.getPermissionname());
		}
		return list;
	}

	private List<Permission> getPermissionList() {
		// TODO Auto-generated method stub
		return permissionList;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + "]";
	}

}
