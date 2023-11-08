package com.thai27.trangtintuc_v3_be.Service;

import com.thai27.trangtintuc_v3_be.Model.TrangTinTucUser;

public interface UserService {
	
	String getUsernameByToken (String token);

	int checkUsername(String username);
	
	int checkEmail(String username);
	
	int insertUser(String username, String password, String email);
	
	int getUserId(String username);
	
	int insertDefaultRole(int userId);
	
	String getEmail(String username);
	
	String changePassword(String username, String newPassword);
	
	TrangTinTucUser resetPassword(String newPassword, String username);
	
}
