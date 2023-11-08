package com.thai27.trangtintuc_v3_be.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tu_khoa_bai_bao")
public class TuKhoaBaiBao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ten_tu_khoa")
	private String tenTuKhoa;

	@ManyToMany(targetEntity = BaiBao.class, mappedBy = "tuKhoaBaiBao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<BaiBao> baiBao;

}
