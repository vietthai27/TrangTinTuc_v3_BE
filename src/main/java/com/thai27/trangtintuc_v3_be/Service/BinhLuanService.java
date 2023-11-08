package com.thai27.trangtintuc_v3_be.Service;

import com.thai27.trangtintuc_v3_be.Model.BinhLuan;

public interface BinhLuanService {

	void deleteBinhLuan(Long id);

	public BinhLuan editBinhLuan(Long id, String noiDung);
}
