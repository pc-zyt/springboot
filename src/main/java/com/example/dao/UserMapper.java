package com.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.pojo.UserInfo;

@Mapper
public interface UserMapper {
	//获取用户基本信息
    @Select("select * from t_spring_user where userId = #{userId}")
	UserInfo selectUserInfo(@Param("userId") String userId);

    //更新密码输入错误次数
    @Update("update t_spring_user set pwdErrorNum=pwdErrorNum+#{num},isLock=0,updateDate=now() where userId = #{userId}")
	void updatePwdErrorNum(@Param("userId")String userId, @Param("num") int num);

    //锁定账户，更新密码错误数，修改时间，锁定状态,锁定时间
    @Update("update t_spring_user set pwdErrorNum=0,isLock=1,updateDate=now() where userId = #{userId}")
	void updateLockState(String userId);

    //修改用户密码
    @Update("update t_spring_user set password = #{newPassword},updateDate = now(),modifypwdDate=now() where userId = #{userId}")
	void modifyPassword(@Param("userId")String userId, @Param("newPassword")String newPassword);

    //添加用户
    @Insert("insert into t_spring_user(userId,password,createDate)values(#{userId},#{password},now())")
	void addUserInfo(@Param("userId")String userId, @Param("password")String password);
	
}
