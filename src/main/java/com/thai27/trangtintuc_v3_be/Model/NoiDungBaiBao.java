package com.thai27.trangtintuc_v3_be.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "noi_dung_bai_bao")
public class NoiDungBaiBao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nd_bai_bao",columnDefinition = "TEXT")
	private String ndBaiBao;
	
	@Column(name = "anh_nd_bai_bao")
	private String anhNdBaiBao;
	
	@Column(name = "tieu_de_anh_nd_bai_bao")
	private String tieuDeAnhNoiDungBaiBao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bai_bao_id")
	@JsonIgnore
	private BaiBao baiBao;
}

