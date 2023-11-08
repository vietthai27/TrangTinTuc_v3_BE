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
@Table(name = "binh_luan")
public class BinhLuan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "noi_dung_binh_luan")
	private String noiDungBinhLuan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore	
	@JoinColumn(name = "bai_bao_id")
	private BaiBao baiBao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore	
	@JoinColumn(name = "user_id")
	private TrangTinTucUser user;
	
}
