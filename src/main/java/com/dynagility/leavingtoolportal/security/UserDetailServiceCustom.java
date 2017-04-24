package com.dynagility.leavingtoolportal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.model.Account;


@Service
public class UserDetailServiceCustom implements UserDetailsService {
	@Autowired
	private AccountDao accountDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountDao.findByUsername(username);
		if (account != null) {
			String role  = account.getRole().getName();
		return new User(account.getUsername(), account.getPassword(), true, true, true, true,				
					AuthorityUtils.createAuthorityList(role));
		} else {
			throw new UsernameNotFoundException("could not find the user '" + username + "'");
		}
	}

}