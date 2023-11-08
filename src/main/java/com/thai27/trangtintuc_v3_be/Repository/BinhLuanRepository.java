package com.thai27.trangtintuc_v3_be.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.thai27.trangtintuc_v3_be.Model.BinhLuan;


@Repository
public interface BinhLuanRepository extends JpaRepository<BinhLuan, Long>{

}

