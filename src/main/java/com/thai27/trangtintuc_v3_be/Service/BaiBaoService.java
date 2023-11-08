package com.thai27.trangtintuc_v3_be.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.thai27.trangtintuc_v3_be.DTO.BaiBaoDTO.BaiBaoMiniDTO;
import com.thai27.trangtintuc_v3_be.Model.BaiBao;

public interface BaiBaoService {

	Optional<BaiBao> getBaiBaoById (Long id);
	
	List<BaiBaoMiniDTO> getBaiBaoMoiNhat();
	
	List<BaiBaoMiniDTO> getBaiBaoNoiBat();
	
	List<BaiBaoMiniDTO> getBaiBaoYeuThich();
	
	Page<BaiBaoMiniDTO> searchBaiBao(String firstname,Integer pageNum, Integer pageSize);
	
	Page<BaiBaoMiniDTO> getBaiBaoByDanhMuc(Long id,Integer pageNum, Integer pageSize);
	
	int getBaiBaoLikes (Long id);
	
	int checkUserLikeState (Long id, Long userId);
	
	int insertLike (Long id, Long userId);
	
}
