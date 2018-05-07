package com.example.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.UserMapper;
import com.example.pojo.UserInfo;
import com.example.util.Constant;
import com.example.util.MD5Tools;

@Service
public class LoginService {
	@Autowired
	UserMapper userMapper;
	/**
	 * 用户登录
	 * @author zyt
	 * @param userId
	 * @param password
	 */
	public Map<String, Object> login(String userId, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date nowDate = new Date();
		boolean checkUserId=(null==userId||"".equals(userId));
        // 判断密码是否为空
        boolean checkPassword=(null==password||"".equals(password));
        if(checkUserId||checkPassword){
        	map.put("success", false);
        	map.put("errMsg", "用户名或密码不能为空");
            return map;
        }
		//password进行 md5解密
//        password = MD5Tools.hexStringToBytes(password).toString();
        System.out.println(password);
		//根据用户名获取用户信息
		UserInfo userInfo = userMapper.selectUserInfo(userId);
		if(userInfo==null) {
			map.put("success", false);
        	map.put("errMsg", "用户名或密码输入错误！");
        	return map;
		}
		//判断用户是否被锁定
		if(userInfo.getIsLock()==1) {
			int lockedTime = (int) ((nowDate.getTime()-userInfo.getUpdateDate().getTime())/1000);
			if(lockedTime<=Constant.LOCKTIME) {
				map.put("success", false);
	        	map.put("errMsg", "账户已被锁定！距离解锁还有："+(Constant.LOCKTIME-lockedTime)+"秒");
	        	return map;
			}
		}
		//密码错误到达上限
		if(Constant.PWDERRORNUM<=userInfo.getPwdErrorNum()) {
			map.put("success", false);
        	map.put("errMsg", "密码输入错误"+Constant.PWDERRORNUM+"次，账户已被锁定！");
        	//密码错误置为0
			userMapper.updateLockState(userId);
        	return map;
		}
		//密码正确
		if(password.equals(userInfo.getPassword())) {
			//判断用户是否第一次登录---更新表信息日期为空，表示第一次登录
			if(userInfo.getUpdateDate()==null) {
				map.put("firstLogin", "1");//用户第一次登录
			}
			//密码是否过期
			if(userInfo.getModifypwdDate()!=null) {
				int pwdTimeLimit = (int) ((nowDate.getTime()-userInfo.getModifypwdDate().getTime())/(24*60*60*1000));
				if(Constant.PWDERRORNUM<=pwdTimeLimit) {
					map.put("pwdOverdue", "1");//密码过期，需修改
				}
			}
			//密码错误置为0
			userMapper.updatePwdErrorNum(userId, 0);
			map.put("success", true);
			map.put("sucMsg", "登录成功！");
		}else {
			//密码错误加1
			userMapper.updatePwdErrorNum(userId, 1);
			map.put("success", false);
        	map.put("errMsg", "用户名或密码输入错误！");
        	return map;
		}
		return map;
	}
	
	/**
	 * 修改密码
	 * @param userId
	 * @param password
	 * @return
	 * @author zyt
	 */
	public Map<String, Object> modify(String userId, String oldPassword, String newPassword) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean checkOldPassword=(null==oldPassword||"".equals(oldPassword));
        // 判断密码是否为空
        boolean checkNewPassword=(null==newPassword||"".equals(newPassword));
        if(checkOldPassword||checkNewPassword){
        	map.put("success", false);
        	map.put("errMsg", "新旧密码都不能为空！");
            return map;
        }
        //password进行md5解密
//        oldPassword = MD5Tools.hexStringToBytes(oldPassword).toString();
//        newPassword = MD5Tools.hexStringToBytes(newPassword).toString();
		if(oldPassword.equals(newPassword)) {
			map.put("success", false);
        	map.put("errMsg", "新旧密码不能相同！");
            return map;
		}
		UserInfo userInfo = userMapper.selectUserInfo(userId);
		if(userInfo==null) {
			map.put("success", false);
        	map.put("errMsg", "无该用户！");
        	return map;
		}
		//判断用户是否被锁定
		if(userInfo.getIsLock()==1) {
			map.put("success", false);
        	map.put("errMsg", "该用户已被锁定，无法修改密码！");
        	return map;
		}
		userMapper.modifyPassword(userId, newPassword);
		map.put("success", true);
		map.put("sucMsg", "密码修改成功！");
    	return map;
	}
	/**
	 * 用户注册
	 * @param userId
	 * @param password
	 * @return
	 * @author zyt
	 */
	public Map<String, Object> register(String userId, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean checkUserId=(null==userId||"".equals(userId));
        // 判断密码是否为空
        boolean checkPassword=(null==password||"".equals(password));
        if(checkUserId||checkPassword){
        	map.put("success", false);
        	map.put("errMsg", "用户名与密码不能为空");
            return map;
        }
		//password进行 md5解密
//        password = MD5Tools.hexStringToBytes(password).toString();
        UserInfo userInfo = this.userMapper.selectUserInfo(userId);
        if(userInfo!=null) {
        	map.put("success", false);
        	map.put("errMsg", "用户名已被使用！");
            return map;
        }
        //添加用户
        this.userMapper.addUserInfo(userId, password);
        map.put("success", true);
    	map.put("sucMsg", "注册成功！");
		return map;
	}
}
