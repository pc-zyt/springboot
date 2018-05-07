package com.example.controllor;

import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.LoginService;

@RestController
@RequestMapping("/gyzq")
public class LoginControllor {
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/register")
	@ResponseBody
	public Map<String, Object> register(@RequestParam String userId,
            @RequestParam  String password,
            HttpSession session){
        Map<String, Object> map = loginService.register(userId,password);
        return map;
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(@RequestParam String userId,
            @RequestParam  String password,
            HttpSession session){
        Map<String, Object> map = loginService.login(userId,password);
        return map;
	}
	
	@RequestMapping("/modify")
	@ResponseBody
	public Map<String, Object> modify(@RequestParam String userId, @RequestParam String oldPassword,
            @RequestParam  String newPassword,
            HttpSession session){
        Map<String, Object> map = loginService.modify(userId, oldPassword,newPassword);
		return map;
	}
}
