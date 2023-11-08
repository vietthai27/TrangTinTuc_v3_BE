package com.thai27.trangtintuc_v3_be.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thai27.trangtintuc_v3_be.DTO.BaiBaoDTO.BaiBaoMiniDTO;
import com.thai27.trangtintuc_v3_be.Model.BaiBao;
import com.thai27.trangtintuc_v3_be.ServiceImplement.BaiBaoServiceImplement;

@CrossOrigin("*")
@RestController
@RequestMapping("/baibao")
public class BaiBaoController {

	@Autowired
	BaiBaoServiceImplement baiBaoSrvImp;

	@GetMapping("/pass/{id}")
	Optional<BaiBao> getBaiBaoById(@PathVariable Long id) {
		return baiBaoSrvImp.getBaiBaoById(id);
	}

	@GetMapping("/pass/moinhat")
	List<BaiBaoMiniDTO> getBaiBaoMoiNhat() {
		return baiBaoSrvImp.getBaiBaoMoiNhat();
	}

	@GetMapping("/pass/noibat")
	List<BaiBaoMiniDTO> getBaiBaoNoiBat() {
		return baiBaoSrvImp.getBaiBaoNoiBat();
	}

	@GetMapping("/pass/yeuthich")
	List<BaiBaoMiniDTO> getBaiBaoYeuThich() {
		return baiBaoSrvImp.getBaiBaoYeuThich();
	}

	@GetMapping("/pass/searchBaiBao")
	Page<BaiBaoMiniDTO> searchBaiBao(@RequestParam String search, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
		return baiBaoSrvImp.searchBaiBao(search,pageNum,pageSize);
	}
	
	@GetMapping("/pass/getBaiBaoByDanhMuc")
	Page<BaiBaoMiniDTO> getBaiBaoByDanhMuc(@RequestParam Long id, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
		return baiBaoSrvImp.getBaiBaoByDanhMuc(id,pageNum,pageSize);
	}
	
	@GetMapping("/pass/getBaiBaoLikes")
	int getBaiBaoLikes(@RequestParam Long id) {
		return baiBaoSrvImp.getBaiBaoLikes(id);
	}
	
	@GetMapping("/checkUserLikeState")
	boolean checkUserLikeState(@RequestParam Long id, @RequestParam Long userId) {
		if(baiBaoSrvImp.checkUserLikeState(id, userId) == 1) {
			return true;
		} else return false;
	}
	
	@PostMapping("/insertLike")
	String insertLike (@RequestParam Long id, @RequestParam Long userId) {
		if ( baiBaoSrvImp.insertLike(id, userId) == 1)
		return "Đã gửi lượt thích";
		else return "Có lỗi xảy ra";
	}
}
