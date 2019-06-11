package com.iamlook.mapper;


import com.iamlook.model.User;
import com.iamlook.model.UserBean;

import java.util.List;

public interface UserMapper {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

    List getTestAll();

	List<UserBean> getUserBeanAll();

}