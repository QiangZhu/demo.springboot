package com.fable.shiro.shiro;

import com.fable.shiro.domain.Role;
import com.fable.shiro.domain.User;
import com.fable.shiro.service.UserService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class MyShiroCasRealm extends CasRealm{
	@Autowired
	private UserService userService;

	/**
	 * 登录认证
	 */
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//		//UsernamePasswordToken用于存放提交的登录信息
//		UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//		User user = userService.findByUsername(token.getUsername());
//		if (user != null){
//			// 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
//		}
//		return null;
//	}

	/**
	 * 权限认证（为当前登录的Subject授予角色和权限）
	 *
	 * 该方法的调用时机为需授权资源被访问时，并且每次访问需授权资源都会执行该方法中的逻辑，这表明本例中并未启用AuthorizationCache，
	 * 如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（也就是cache时间，在ehcache-shiro.xml中配置），
	 * 超过这个时间间隔再刷新页面，该方法会被执行
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String loginName = (String) super.getAvailablePrincipal(principals);
		User user = userService.findByUsername(loginName);
		if (user != null){
			// 权限信息对象info，用来存放查出的用户的所有的角色及权限
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setRoles(user.getRolesName());
			List<Role> roleList = user.getRoleList();
			for (Role role : roleList){
				info.addStringPermissions(role.getPermissionsName());
			}
			return info;
		}
		// 返回null将会导致用户访问任何被拦截的请求时都会自动跳转到unauthorizedUrl指定的地址
		return null;
	}
}
