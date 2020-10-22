package com.lhu.springbootSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lhu.springbootSecurity.Model.User;
import com.lhu.springbootSecurity.repository.UserMngRepository;

@Service // @Component is ok
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMngRepository userMngRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername UserName : " + username);
		User user = userMngRepo.findByUserName(username);
		if (user == null)
			throw new UsernameNotFoundException("User not found");
		System.out.println("Fetch User : " + user.toString());
		return new UserDetailsImpl(user);
	}

}
