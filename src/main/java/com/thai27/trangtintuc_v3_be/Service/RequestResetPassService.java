package com.thai27.trangtintuc_v3_be.Service;

public interface RequestResetPassService {

    String sendResetPassRequest(String username) throws Exception;
	
	String validateResetPassRequest(String username, String codeResetPass);
	
}
