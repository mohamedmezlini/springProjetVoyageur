package com.tn.isamm.voyageur.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "Fidelite")
public class Fidelite {
	private Integer idFidelite;
	@NotNull
	private Integer fd=5;

	@NotNull
	private Integer reduction=0;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdFidelite() {
		return idFidelite;
	}

	public void setIdFidelite(Integer idFidelite) {
		this.idFidelite = idFidelite;
	}

	@Basic(optional = false)
	@Column(name = "fd",unique=true)
	public Integer getFd() {
		return fd;
	}

	public void setReduction(Integer reduction) {
		this.reduction = reduction;
	}
	@Basic(optional = false)
	@Column(name = "Reduction",unique=true)
	public Integer getReduction() {
		return reduction;
	}

	public void setFd(Integer fd) {
		this.fd = fd;
	}

	

	@Override
	public String toString() {
		return "Fidelite [idFidelite=" + idFidelite + ", fd=" + fd
				+ "]";
	}

}
