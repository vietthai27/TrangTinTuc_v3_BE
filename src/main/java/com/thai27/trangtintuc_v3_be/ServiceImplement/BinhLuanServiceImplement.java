package com.thai27.trangtintuc_v3_be.ServiceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thai27.trangtintuc_v3_be.Model.BinhLuan;
import com.thai27.trangtintuc_v3_be.Repository.BinhLuanRepository;
import com.thai27.trangtintuc_v3_be.Service.BinhLuanService;


@Service
public class BinhLuanServiceImplement implements BinhLuanService{

	@Autowired
	BinhLuanRepository repo;
	
	@Override
	public void deleteBinhLuan(Long id) {
		repo.deleteById(id);
	}

	@Override
	public BinhLuan editBinhLuan(Long id,String noiDung) {
		BinhLuan binhLuan = repo.findById(id).orElse(null);
		binhLuan.setNoiDungBinhLuan(noiDung);
		binhLuan = repo.save(binhLuan);
		return binhLuan;
	}

}
