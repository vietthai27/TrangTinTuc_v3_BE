package com.thai27.trangtintuc_v3_be.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.thai27.trangtintuc_v3_be.Model.BaiBaoLike;

public interface BaiBaoLikeRepository extends JpaRepository<BaiBaoLike, Long>{

	@Query(value = "select count(id) from bai_bao_like where bai_bao_id = :id ",nativeQuery = true)
	int getBaiBaoLikes(@Param("id") Long id);
	
	@Query(value = "select count(id) from bai_bao_like where bai_bao_id = :id and trang_tin_tuc_user_id = :userId",nativeQuery = true)
	int checkUserLikeState(@Param("id") Long id, @Param ("userId") Long userId);
	
	@Modifying
	@Transactional
	@Query(value = "insert into bai_bao_like (bai_bao_id,trang_tin_tuc_user_id) values (:id,:userId)", nativeQuery = true)
	int insertLike(@Param("id") Long id, @Param ("userId") Long userId);
	
	
}
