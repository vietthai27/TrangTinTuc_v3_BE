package com.thai27.trangtintuc_v3_be.ServiceImplement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thai27.trangtintuc_v3_be.Exception.ResourceNotFoundException;
import com.thai27.trangtintuc_v3_be.Repository.RequestResetPassRepository;
import com.thai27.trangtintuc_v3_be.Service.RequestResetPassService;
import com.thai27.trangtintuc_v3_be.Util.GenerateRandomString;
import com.thai27.trangtintuc_v3_be.Util.SendEmail;

@Service
public class RequestResetPassServiceImplement implements RequestResetPassService {

	@Autowired
	RequestResetPassRepository rqResetPassRepo;
	
	@Autowired
	UserServiceImplement userSrvImp;

	@Autowired
	GenerateRandomString ramStrGen;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	SendEmail mail;

	@Override
	public String sendResetPassRequest(String username) throws ResourceNotFoundException {
		if (userSrvImp.checkUsername(username) == 0) {
			throw new ResourceNotFoundException("Tên người dùng: "+username+" không tồn tại trong hệ thống");
		} else {
			String userEmail = userSrvImp.getEmail(username);
			String codeResetPass = ramStrGen.generateRandomCode();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String currentdate = dtf.format(now);
			rqResetPassRepo.insertResetPassRequest(codeResetPass, currentdate, username);
			mail.sendCodeResetPass(userEmail, codeResetPass);
			return "Gửi yêu cầu thành công kiểm tra email !";
		}
	}

	@Override
	public String validateResetPassRequest(String username, String codeResetPass) {
		String getCodeResetPass = rqResetPassRepo.getCodeResetPass(username);
		if (getCodeResetPass.equals(codeResetPass)) {
			List<Long> listId = rqResetPassRepo.getAllIdByUsername(username);
			String userEmail = userSrvImp.getEmail(username);
			String newPassword = ramStrGen.generateRandomCode();
			String newPasswordEncode = encoder.encode(newPassword);
			userSrvImp.resetPassword(newPasswordEncode, username);
			for (int i = 0; i < listId.size(); i++) {
				rqResetPassRepo.deleteById(listId.get(i));
			}			
			mail.sendSuccessResetPass(userEmail, username, newPassword);
			return "Reset mật khẩu thành công !";
		} else
			return "Mã xác thực không chính xác !";
	}



}
