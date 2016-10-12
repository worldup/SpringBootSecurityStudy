package com.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetailsImpl extends User {

	private String nickName;
	
	public UserDetailsImpl(Account account) {
		super(account.getEmail(), account.getPassword(), getauthorities(account.getRoles()));
		this.nickName = account.getNickName();
	}

	private static Collection<? extends GrantedAuthority> getauthorities(List<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();

		roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
		
		return authorities;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
