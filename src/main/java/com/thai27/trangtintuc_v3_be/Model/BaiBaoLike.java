package com.thai27.trangtintuc_v3_be.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bai_bao_like")
public class BaiBaoLike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "bai_bao_id", referencedColumnName = "id")
	private BaiBao baiBao;

	@OneToOne
	@JoinColumn(name = "trang_tin_tuc_user_id", referencedColumnName = "id")
	private TrangTinTucUser user;

}
