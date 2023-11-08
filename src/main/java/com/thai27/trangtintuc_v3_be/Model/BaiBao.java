package com.thai27.trangtintuc_v3_be.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "bai_bao")
public class BaiBao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "ten_bai_bao")
	private String tenBaiBao;

	@Column(name = "tieu_de")
	private String tieuDe;

	@Column(name = "ngay_dang")
	private String ngayDang;

	@Column(name = "bao_noi")
	private String baoNoi;
	
	@Column(name = "anh_thu_nho")
	private String anhThuNho;

	@Column(name = "tac_gia")
	private String tacGia;

	@Column(name = "luot_xem")
	private int luotXem ;
	
	@Column(name = "luot_thich")
	private int luotThich;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "baiBao")
	private List<NoiDungBaiBao> noiDungBaiBao;

	@ManyToMany(targetEntity = TuKhoaBaiBao.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TuKhoaBaiBao> tuKhoaBaiBao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore	
	@JoinColumn(name = "danh_muc_con_id")
	private DanhMucCon danhMucCon;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "baiBao")
	@JsonIgnore	
	private List<BinhLuan> binhLuan;

}
