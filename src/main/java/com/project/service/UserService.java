package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.data.model.UserInfo;

@Service
public interface UserService {

	/**
	 * @param User
	 * @return
	 */
	void addUser(UserInfo user);

	/**
	 * @param customer
	 */
	void updateUser(UserInfo user);

	/**
	 * @param id
	 */
	void deleteUser(Long id);


	/**
	 * 
	 */
	List<UserInfo> allUser();

	/**
	 * @param id
	 * @return
	 */
	UserInfo getUser(Long id);

	Optional<UserInfo> getUserByUserIdAndPassword(UserInfo user);


}
