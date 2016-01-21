package com.tn.isamm.voyageur.beans;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="Voyage")
public class Voyage {
	
	
	private Integer idVoyage;
	@NotEmpty
	private String image;
	@NotEmpty
	private String pays;
	@NotEmpty
	private String villeDepart;
	@NotEmpty
	private String villeArrivee;
	
	@NotNull
	private Date dateDepart;
	@NotNull
	private Date dateArrivee;
	@NotNull
	private Double prix;
	@NotNull
	private Integer nbDispo;
	
	private Integer nbVendu;
	private Set<Client> clients = new HashSet<Client>();
	private Set<Panier> paniers = new HashSet<Panier>();

	@OneToMany(mappedBy = "voyage")
	public Set<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(Set<Panier> paniers) {
		this.paniers = paniers;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdVoyage() {
		return idVoyage;
	}

	public void setIdVoyage(Integer idVoyage) {
		this.idVoyage = idVoyage;
	}

	@Basic(optional = false)
	@Column(name = "pays")
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Basic(optional = false)
	@Column(name = "ville_depart")
	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	@Basic(optional = false)
	@Column(name = "ville_arrivee")
	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	@Basic(optional = false)
	@Column(name = "date_depart")
	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	@Basic(optional = false)
	@Column(name = "date_arrivee")
	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	@Basic(optional = false)
	@Column(name = "prix")
	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Basic(optional = false)
	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Basic(optional = false)
	@Column(name = "nb_dispo")
	public Integer getNbDispo() {
		return nbDispo;
	}

	public void setNbDispo(Integer nbDispo) {
		this.nbDispo = nbDispo;
	}

	@Basic(optional = false)
	@Column(name = "nb_vendu")
	public Integer getNbVendu() {
		return nbVendu;
	}

	public void setNbVendu(Integer nbVendu) {
		this.nbVendu = nbVendu;
	}

	@ManyToMany(mappedBy = "voyages")
	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	
	@Override
	public String toString() {
		return "Voyage [idVoyage=" + idVoyage + ", image=" + image + ", nbVendu=" + nbVendu + ", nbDispo=" + nbDispo
				+ ", prix=" + prix + ", dateArrivee=" + dateArrivee
				+ ", dateDepart=" + dateDepart  
				+ ", villeArrivee=" + villeArrivee  
				+ ", villeDepart=" + villeDepart 
				+ ", pays=" + pays + "]";
	}


	
}
