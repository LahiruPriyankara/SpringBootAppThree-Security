package com.lhu.springbootSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lhu.springbootSecurity.Model.User;

public interface UserMngRepository extends JpaRepository<User, Long> {
	User findByUserName(String username);
}
