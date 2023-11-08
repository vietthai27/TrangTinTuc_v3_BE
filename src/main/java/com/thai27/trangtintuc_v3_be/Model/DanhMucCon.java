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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "danh_muc_con")
public class DanhMucCon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ten_danh_muc_con")
	private String tenDanhMucCon;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore	
	@JoinColumn(name = "danh_muc_bai_bao_id")
	private DanhMucBaiBao danhMucBaiBao;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "danhMucCon")
	private List<BaiBao> baiBao;
}
