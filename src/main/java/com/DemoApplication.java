package com;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.domain.Account;
import com.domain.Role;
import com.repository.AccountRepository;
import com.repository.RoleRepository;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	InitializingBean insertUsers(){
		return () -> {

			Role roleUser = new Role();
			roleUser.setRole("ROLE_USER");
			roleUser = roleRepository.save(roleUser);

			Role roleAdmin = new Role();
			roleAdmin.setRole("ROLE_ADMIN");
			roleAdmin = roleRepository.save(roleAdmin);
			
			Account accountUser = new Account();
			accountUser.setEmail("yihoyoung1@nate.com");
			accountUser.setNickName("갓 제임스");
			accountUser.setPassword("1234");
			accountUser = accountRepository.save(accountUser);
			accountUser.addRole(roleUser);
			accountRepository.save(accountUser);
			
			Account accountAdmin = new Account();
			accountAdmin.setEmail("yihoyoung2@nate.com");
			accountAdmin.setNickName("갓 제임스");
			accountAdmin.setPassword("1234");
			accountAdmin = accountRepository.save(accountAdmin);
			accountAdmin.addRole(roleUser);
			accountAdmin.addRole(roleAdmin);
			accountRepository.save(accountAdmin);
		};
	}
	
}
