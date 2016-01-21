package com.tn.isamm.voyageur.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "panier")
public class Panier {
	@Embeddable
	public static class Id implements Serializable {
		@Column(name = "idClient")
		private Integer idClient;
		@Column(name = "idVoyage")
		private Integer idVoyage;

		public Id() {
		}

		public Id(Integer idClient, Integer idVoyage) {
			this.idClient = idClient;
			this.idVoyage = idVoyage;
		}

		public int getIdVoyage() {
			// TODO Auto-generated method stub
			return this.idVoyage; 
		}
		public int getIdClient() {
			// TODO Auto-generated method stub
			return this.idClient; 
		}

	}

	@EmbeddedId
	private Id id = new Id();
	@NotNull
	@Column(name = "nb")
	private Integer nb;
	
	public Integer getNb() {
		return nb;
	}

	public void setNb(Integer nb) {
		this.nb = nb;
	}
	
	@Column(name = "prix")
	private Double prix;
	
	@Column(name = "date")
	private Date date;
	

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "etat")
	private String etat;
	@ManyToOne
	@JoinColumn(name = "idClient", insertable = false, updatable = false)
	private Client client;

	@ManyToOne
	@JoinColumn(name = "idVoyage", insertable = false, updatable = false)
	private Voyage voyage;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	public Panier()
	{
		
	}

	public Panier(String etat, Client client, Voyage voyage, Integer nb) {
		this.id.idClient=client.getIdClient();
		this.id.idVoyage=voyage.getIdVoyage();
		this.etat = etat;
		this.client = client;
		this.voyage = voyage;
		this.nb=nb; 
		client.getPaniers().add(this);
		voyage.getPaniers().add(this);
	}

	public Panier(String etat, Client client, Voyage voyage, Integer nb , Double Prix, Date date) {
		this.id.idClient=client.getIdClient();
		this.id.idVoyage=voyage.getIdVoyage();
		this.etat = etat;
		this.client = client;
		this.voyage = voyage;
		this.nb=nb; 
		this.prix=Prix; 
		this.date=date; 
		client.getPaniers().add(this);
		voyage.getPaniers().add(this);
	}
	
}
