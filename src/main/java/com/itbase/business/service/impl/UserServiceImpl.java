package com.itbase.business.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itbase.business.service.UserService;
import com.itbase.jdbc.dao.UserDao;
import com.itbase.jdbc.entity.User;
import com.itbase.plugin.vo.UserVo;

@Repository
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserVo findById(Integer id) {
		Optional<User> opt = userDao.findById(id);
		if(opt.isPresent()) {
			User user=opt.get();
			return new UserVo(user.getName(),user.getAge());
		}
		return new UserVo("未知用户",100);
	}

	
}
