 package com.thai27.trangtintuc_v3_be.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thai27.trangtintuc_v3_be.DTO.BaiBaoDTO.BaiBaoMiniDTO;
import com.thai27.trangtintuc_v3_be.Model.BaiBao;



@Repository
public interface BaiBaoRepository extends JpaRepository<BaiBao, Long> {
	
//	@Query(value = "SELECT \r\n"
//			+ "	a.id,a.ten_bai_bao,a.ngay_dang,a.anh_mini,a.tac_gia,a.tieu_de,a.luot_xem\r\n"
//			+ " FROM \r\n"
//			+ "	bai_bao a, noi_dung_bai_bao c\r\n"
//			+ " WHERE \r\n"
//			+ "	a.id = c.bai_bao_id and\r\n"
//			+ "	(LOWER(a.tieu_de)  LIKE LOWER (concat('%', :search,'%')) or\r\n"
//			+ "	LOWER(a.ten_bai_bao)  LIKE LOWER (concat('%', :search,'%')) or\r\n"
//			+ "	LOWER(a.tieu_de)  LIKE LOWER (concat('%', :search,'%')) or\r\n"
//			+ "	LOWER(c.nd_bai_bao)  LIKE LOWER (concat('%', :search,'%')))\r\n"
//			+ "	group by a.id;",nativeQuery = true)
//	List<BaiBaoMiniDTO> searchBaiBao(@Param("search") String search);
	
//	@Query(value = "select\r\n"
//			+ "a.id as id,a.ten_bai_bao as tenBaiBao,a.ngay_dang as ngayDang,a.anh_thu_nho as anhThuNho,a.tac_gia as tacGia,a.tieu_de as tieuDe,a.luot_xem as luotXem,a.luot_thich as luotThich\r\n"
//			+ "from \r\n"
//			+ "bai_bao a \r\n"
//			+ ",noi_dung_bai_bao c\r\n"
//			+ "where \r\n"
//			+ "a.id = c.bai_bao_id and\r\n"
//			+ "LOWER(a.ten_bai_bao) LIKE LOWER (concat('%', :search,'%')) \r\n"
//			+ "or \r\n"
//			+ "a.id = c.bai_bao_id and\r\n"
//			+ "LOWER(a.tieu_de) LIKE LOWER (concat('%', :search,'%')) \r\n"
//			+ "or \r\n"
//			+ "a.id = c.bai_bao_id and\r\n"
//			+ "LOWER(c.nd_bai_bao)  LIKE LOWER (concat('%', :search,'%')) \r\n"
//			+ "group by \r\n"
//			+ "a.id",nativeQuery = true)
//	Page<BaiBaoMiniDTO> searchBaiBao(@Param("search") String search, Pageable pageable);
	
	@Query(value = "select\r\n"
			+ "a.id as id,a.ten_bai_bao as tenBaiBao,a.ngay_dang as ngayDang,a.anh_thu_nho as anhThuNho,a.tac_gia as tacGia,a.tieu_de as tieuDe,a.luot_xem as luotXem,a.luot_thich as luotThich\r\n"
			+ "from \r\n"
			+ "bai_bao a \r\n"
			+ ",noi_dung_bai_bao c\r\n"
			+ "where \r\n"
			+ "a.id = c.bai_bao_id and\r\n"
			+ "a.ten_bai_bao LIKE %:search%\r\n"
			+ "or \r\n"
			+ "a.id = c.bai_bao_id and\r\n"
			+ "a.tieu_de LIKE %:search% \r\n"
			+ "or \r\n"
			+ "a.id = c.bai_bao_id and\r\n"
			+ "c.nd_bai_bao  LIKE %:search% \r\n"
			+ "group by \r\n"
			+ "a.id",nativeQuery = true)
	Page<BaiBaoMiniDTO> searchBaiBao(@Param("search") String search, Pageable pageable);
	
	@Query(value = "select\r\n"
			+ "a.id as id,a.ten_bai_bao as tenBaiBao,a.ngay_dang as ngayDang,a.anh_thu_nho as anhThuNho,a.tac_gia as tacGia,a.tieu_de as tieuDe,a.luot_xem as luotXem,a.luot_thich as luotThich\r\n"
			+ "from \r\n"
			+ "bai_bao a \r\n"
			+ "where a.danh_muc_con_id = :id",nativeQuery = true)
	Page<BaiBaoMiniDTO> getBaiBaoByDanhMuc(@Param("id") Long id, Pageable pageable);
	
	@Query(value = "select \r\n"
			+ "a.id as id,a.ten_bai_bao as tenBaiBao,to_date(a.ngay_dang,'DD-MM-YYYY') as ngayDang,a.anh_thu_nho as anhThuNho,a.tac_gia as tacGia,a.tieu_de as tieuDe,a.luot_xem as luotXem,a.luot_thich as luotThich\r\n"
			+ "from \r\n"
			+ "bai_bao a \r\n"
			+ "order by \r\n"
			+ "ngayDang desc\r\n"
			+ "limit 4",nativeQuery = true)
	List<BaiBaoMiniDTO> getBaiBaoMoiNhat();
	
	@Query(value = "select \r\n"
			+ "	a.id as id,a.ten_bai_bao as tenBaiBao,a.ngay_dang as ngayDang,a.anh_thu_nho as anhThuNho,a.tac_gia as tacGia,a.tieu_de as tieuDe,a.luot_xem as luotXem,a.luot_thich as luotThich \r\n"
			+ "from \r\n"
			+ "	bai_bao a \r\n"
			+ "order by \r\n"
			+ "	luot_xem desc\r\n"
			+ "limit 4",nativeQuery = true)
	List<BaiBaoMiniDTO> getBaiBaoNoiBat();
	
	@Query(value = "select \r\n"
			+ "	a.id as id,a.ten_bai_bao as tenBaiBao,a.ngay_dang as ngayDang,a.anh_thu_nho as anhThuNho,a.tac_gia as tacGia,a.tieu_de as tieuDe,a.luot_xem as luotXem,a.luot_thich as luotThich \r\n"
			+ "from \r\n"
			+ "	bai_bao a \r\n"
			+ "order by \r\n"
			+ "	luot_thich desc\r\n"
			+ "limit 4",nativeQuery = true)
	List<BaiBaoMiniDTO> getBaiBaoYeuThich();



	
}
