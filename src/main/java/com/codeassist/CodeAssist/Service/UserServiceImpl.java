package com.codeassist.CodeAssist.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeassist.CodeAssist.Model.Role;
import com.codeassist.CodeAssist.Model.User;
import com.codeassist.CodeAssist.Repo.RoleRepo;
import com.codeassist.CodeAssist.Repo.UserRepo;


import java.util.HashSet;
/*
 * Overrides UserRepo
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(roleRepo.findAll().iterator().next());
        userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
