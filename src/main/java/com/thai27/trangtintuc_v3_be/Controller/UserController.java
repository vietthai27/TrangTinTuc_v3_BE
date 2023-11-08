package com.thai27.trangtintuc_v3_be.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thai27.trangtintuc_v3_be.JWT.JwtAuthenProvider;
import com.thai27.trangtintuc_v3_be.JWT.JwtUtil;
import com.thai27.trangtintuc_v3_be.Model.TrangTinTucUser;
import com.thai27.trangtintuc_v3_be.ServiceImplement.RequestResetPassServiceImplement;
import com.thai27.trangtintuc_v3_be.ServiceImplement.RequestSignUpServiceImplement;
import com.thai27.trangtintuc_v3_be.ServiceImplement.UserServiceImplement;

@CrossOrigin("*")
@RestController

public class UserController {

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	JwtAuthenProvider jwtAuth;

	@Autowired
	RequestSignUpServiceImplement rqSignupSrvImp;

	@Autowired
	RequestResetPassServiceImplement rqResetPassSrvImp;
	
	@Autowired
	UserServiceImplement userSrvImp;

	@PostMapping("/login")
	public String login(@RequestBody TrangTinTucUser userData) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userData.getUsername(),
				userData.getPassword());
		jwtAuth.authenticate(token);
		String jwtToken = jwtUtil.generate(userData.getUsername());
		return jwtToken;
	}

	@PostMapping("/signupRequest")
	public String signupRequest(@RequestBody TrangTinTucUser userData) {
		return rqSignupSrvImp.sendSignupRequest(userData);
	}

	@PostMapping("/signupValidate")
	public String signupValidate(@RequestBody TrangTinTucUser userData, @RequestParam String codeSignup) {
		return rqSignupSrvImp.validateSignupRequest(userData, codeSignup);
	}

	@PostMapping("/resetPassRequest")
	public String resetPassRequest(@RequestParam String username) throws Exception {
		return rqResetPassSrvImp.sendResetPassRequest(username);
	}

	@PostMapping("/resetPassValidate")
	public String resetPassValidate(@RequestParam String username, @RequestParam String codeResetPass) {
		return rqResetPassSrvImp.validateResetPassRequest(username, codeResetPass);
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam String username, @RequestParam String newPassword) {
		return userSrvImp.changePassword(username, newPassword);		 
	}
	
	@PostMapping("/getUsernameByToken")
	public String getUsernameByToken(@RequestParam String token) {
		return userSrvImp.getUsernameByToken(token);		 
	}

}
