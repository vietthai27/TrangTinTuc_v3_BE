package com.thai27.trangtintuc_v3_be.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.thai27.trangtintuc_v3_be.Model.DanhMucCon;


@Repository
public interface DanhMucConRepository extends PagingAndSortingRepository<DanhMucCon, Long> {

}
