package com.thai27.trangtintuc_v3_be.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thai27.trangtintuc_v3_be.Model.DanhMucBaiBao;
import com.thai27.trangtintuc_v3_be.ServiceImplement.DanhMucBaiBaoServiceImplement;

@CrossOrigin("*")
@RestController
@RequestMapping("/danhmuc")
public class DanhMucBaiBaoController {
	
	@Autowired
	DanhMucBaiBaoServiceImplement danhMucBaiBaoSrvImp;
	
	@GetMapping("/getAllDanhMuc")
	public List<DanhMucBaiBao> getAllDanhMuc(){
		return danhMucBaiBaoSrvImp.getAllBaiBao();	}
}
