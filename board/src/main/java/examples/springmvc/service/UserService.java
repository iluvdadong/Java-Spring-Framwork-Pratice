package examples.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import examples.springmvc.dao.UsersMapper;
import examples.springmvc.dto.User;

@Service
public class UserService {
	@Autowired
	private UsersMapper usersMapper;
	@Transactional(readOnly = true)
	public List<User> getUsers(){
		return usersMapper.getUsers();
	}
	@Transactional(readOnly = true)
	public User getUser(String userId) {
		return usersMapper.getUser(userId);
	}
	@Transactional(readOnly = false)
	public User addUser(User user) {
		usersMapper.addUser(user);
		return user;
	}
}
