package com.fable.shiro.controller;

import com.fable.shiro.domain.CasConfig;
import com.fable.shiro.domain.User;
import com.fable.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
@Controller
//@EnableConfigurationProperties(CasConfig.class)
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CasConfig casConfig;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginForm(Model model){
		model.addAttribute("user", new User());
//		return "login";
		return "redirect:" + casConfig.getLocalServerLoginUrl();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			return "login";
		}

		String username = user.getUsername();
		UsernamePasswordToken token = new UsernamePasswordToken(username, user.getPassword());
		Subject currentUser = SecurityUtils.getSubject();
		try {
			// 将调用MyShiroRealm.doGetAuthenticationInfo()方法
			currentUser.login(token);
		} catch (AuthenticationException e){
			if (e instanceof UnknownAccountException){
				attributes.addFlashAttribute("message", "未知账户");
			} else if (e instanceof IncorrectCredentialsException){
				attributes.addFlashAttribute("message", "密码不正确");
			} else if (e instanceof LockedAccountException){
				attributes.addFlashAttribute("message", "账户已锁定");
			} else if (e instanceof ExcessiveAttemptsException){
				attributes.addFlashAttribute("message", "用户名或密码错误次数超限");
			} else {
				e.printStackTrace();
				attributes.addFlashAttribute("message", "用户名或密码不正确");
			}
		}
		if (currentUser.isAuthenticated()){
			return "redirect:/user";
		} else {
			token.clear();
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(RedirectAttributes attributes){
		SecurityUtils.getSubject().logout();
		attributes.addFlashAttribute("message", "您已安全退出");
//		return "redirect:/login";
		return "redirect:" + casConfig.getCasServerLogoutUrl();
	}

	@RequestMapping("/403")
	public String unauthorizedRole(){
		return "403";
	}

	@RequestMapping("/user")
	public String getUserList(Map<String, Object> model){
		model.put("userList", userService.findAll());
		return "user";
	}

	@RequestMapping("/user/edit/{id}")
	public String toUserEditPage(@PathVariable int id){
		return "user_edit";
	}
}
