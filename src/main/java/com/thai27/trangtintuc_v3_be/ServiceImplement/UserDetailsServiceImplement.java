package com.thai27.trangtintuc_v3_be.ServiceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thai27.trangtintuc_v3_be.DTO.UserDTO.UserDetail;
import com.thai27.trangtintuc_v3_be.Model.TrangTinTucUser;
import com.thai27.trangtintuc_v3_be.Repository.UserRepository;

@Service
public class UserDetailsServiceImplement implements UserDetailsService {


	@Autowired
	UserRepository userRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TrangTinTucUser userInfo = userRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Tài khoản " + username + " không tồn tại trong hệ thống"));
		return UserDetail.build(userInfo);
	}

}
