package com.thai27.trangtintuc_v3_be.Service;

import com.thai27.trangtintuc_v3_be.Model.TrangTinTucUser;

public interface RequestSignupService {
	
	String sendSignupRequest(TrangTinTucUser userData);
	
	String validateSignupRequest(TrangTinTucUser userData, String codeSignup);
	
}
