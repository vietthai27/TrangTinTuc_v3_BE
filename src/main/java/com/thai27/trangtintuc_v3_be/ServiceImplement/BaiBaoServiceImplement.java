package com.thai27.trangtintuc_v3_be.ServiceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thai27.trangtintuc_v3_be.DTO.BaiBaoDTO.BaiBaoMiniDTO;
import com.thai27.trangtintuc_v3_be.Model.BaiBao;
import com.thai27.trangtintuc_v3_be.Repository.BaiBaoLikeRepository;
import com.thai27.trangtintuc_v3_be.Repository.BaiBaoRepository;
import com.thai27.trangtintuc_v3_be.Service.BaiBaoService;

@Service
public class BaiBaoServiceImplement implements BaiBaoService {
	
	@Autowired
	BaiBaoRepository baiBaoRepo;
	
	@Autowired
	BaiBaoLikeRepository baiBaoLikeRepo;

	@Override
	public Optional<BaiBao> getBaiBaoById(Long id) {		
		return baiBaoRepo.findById(id);
	}

	@Override
	public List<BaiBaoMiniDTO> getBaiBaoMoiNhat() {		
		return baiBaoRepo.getBaiBaoMoiNhat();
	}

	@Override
	public List<BaiBaoMiniDTO> getBaiBaoNoiBat() {
		return baiBaoRepo.getBaiBaoNoiBat();
	}

	@Override
	public List<BaiBaoMiniDTO> getBaiBaoYeuThich() {
		return baiBaoRepo.getBaiBaoYeuThich();
	}

	@Override
	public Page<BaiBaoMiniDTO> searchBaiBao(String search,Integer pageNum, Integer pageSize) {
		Pageable pagingBaiBao = PageRequest.of(pageNum, pageSize);
		return baiBaoRepo.searchBaiBao(search, pagingBaiBao);
	}

	@Override
	public Page<BaiBaoMiniDTO> getBaiBaoByDanhMuc(Long id, Integer pageNum, Integer pageSize) {
		Pageable pagingBaiBao = PageRequest.of(pageNum, pageSize);
		return baiBaoRepo.getBaiBaoByDanhMuc(id, pagingBaiBao);
	}

	@Override
	public int getBaiBaoLikes(Long id) {
		System.out.println(id);
		return baiBaoLikeRepo.getBaiBaoLikes(id);
	}

	@Override
	public int checkUserLikeState(Long id, Long userId) {
		return baiBaoLikeRepo.checkUserLikeState(id, userId);
	}

	@Override
	public int insertLike(Long id, Long userId) {
		return baiBaoLikeRepo.insertLike(id, userId);
	}

}
