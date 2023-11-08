package com.thai27.trangtintuc_v3_be.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thai27.trangtintuc_v3_be.Model.DanhMucBaiBao;


@Repository
public interface DanhMucBaiBaoRepository extends JpaRepository<DanhMucBaiBao, Long>  {

}
