package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.data.model.UserInfo;
import com.project.data.model.UserRole;
import com.project.data.repository.RoleRepository;
import com.project.data.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Optional<UserInfo> getUserByUserIdAndPassword(UserInfo user) {

		return userRepository.findByUnameIgnoreCaseAndPassword(user.getUname(), user.getPassword());

	}

	@Override
	public void addUser(UserInfo user) {
		Optional<UserRole> roleOp = roleRepository.findByRoleName(user.getRoleType());
		user.setRole(roleOp.get());
		userRepository.save(user);
	}

	@Override
	public void updateUser(UserInfo user) {
		Optional<UserInfo> userOp = userRepository.findById(user.getUserid());
		if (userOp.isPresent()) {
			UserInfo model = userOp.get();
			model.setUname(user.getUname());
			Optional<UserRole> roleOp = roleRepository.findByRoleName(user.getRoleType());
			model.setRole(roleOp.get());
			model.setRole(roleOp.get());
			userRepository.save(model);
		}
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<UserInfo> allUser() {
		return userRepository.findAll();
	}

	@Override
	public UserInfo getUser(Long id) {
		return userRepository.findById(id).get();
	};

}
