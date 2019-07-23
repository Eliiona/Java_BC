package com.codeassist.CodeAssist.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.codeassist.CodeAssist.Model.Role;
import com.codeassist.CodeAssist.Model.User;
import com.codeassist.CodeAssist.Repo.UserRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;
	 @Override
	    @Transactional(readOnly = true)
	    public UserDetails loadUserByUsername(String username) {
	        User user = userRepo.findByUsername(username);
	        if (user == null) throw new UsernameNotFoundException(username);

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        
	        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
	        System.out.println(user.getRole().getName());
	        

	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	    }
}
