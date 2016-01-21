package com.tn.isamm.voyageur.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "contact")
public class Contact {
	private Integer idContact;
	@NotEmpty
	private String objet;
	@NotEmpty
	private String sujet;
	@NotNull
	private Client client;
	@NotEmpty
	private String repondre;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdContact() {
		return idContact;
	}

	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}

	@Basic(optional = false)
	@Column(name = "objet")
	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	@Basic(optional = false)
	@Column(name = "sujet")
	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	@ManyToOne(targetEntity = com.tn.isamm.voyageur.beans.Client.class)
	@JoinColumn(name = "idClient", nullable = false)
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Contact() {

	}

	public Contact(String objet, String sujet, Client client, String repondre) {

		this.objet = objet;
		this.sujet = sujet;
		this.client = client;
		this.repondre = repondre;
	}
	
	
	public Contact( String repondre) {

	
		this.repondre = repondre;
	}

	@Override
	public String toString() {
		return "Contact [idContact=" + idContact + ", objet=" + objet + ", sujet=" + sujet + ", client=" + client + "]";
	}

	@Basic(optional = false)
	@Column(name = " repondre")
	public String getRepondre() {
		return repondre;
	}

	public void setRepondre(String repondre) {
		this.repondre = repondre;
	}

}
