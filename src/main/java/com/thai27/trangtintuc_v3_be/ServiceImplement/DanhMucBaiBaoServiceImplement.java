package com.thai27.trangtintuc_v3_be.ServiceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thai27.trangtintuc_v3_be.Model.DanhMucBaiBao;
import com.thai27.trangtintuc_v3_be.Repository.DanhMucBaiBaoRepository;
import com.thai27.trangtintuc_v3_be.Service.DanhMucBaiBaoService;

@Service
public class DanhMucBaiBaoServiceImplement implements DanhMucBaiBaoService {
	
	@Autowired
	DanhMucBaiBaoRepository danhMucBaiBaoRepo;
	
	@Override
	public List<DanhMucBaiBao> getAllBaiBao() {		
		return danhMucBaiBaoRepo.findAll();
	}

}
