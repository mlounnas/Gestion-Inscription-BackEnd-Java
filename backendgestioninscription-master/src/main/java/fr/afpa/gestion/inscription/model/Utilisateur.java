package fr.afpa.gestion.inscription.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

////
/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idutilisateur")
	private Integer idutilisateur;

	@Column(length = 300, nullable = true)
	private String adresse;

	@Column(length = 10, unique = true, nullable = true)
	private String codepersonnelcentre;

	@Column(nullable = true)
	private LocalDate datenaissance;

	@Column(length = 100, unique = true, nullable = false)
	private String email;

	@Column(length = 1, nullable = true)
	private Integer etat;

	@Column(length = 20, nullable = true)
	private String nom;

	@Column(length = 30, nullable = false)
	private String password;

	@Column(length = 20, nullable = true)
	private String prenom;

	@Column(length = 15, nullable = true)
	private Integer tel;

	// bi-directional many-to-many association to Role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "jouer", joinColumns = { @JoinColumn(name = "idutilisateur") }, inverseJoinColumns = {
			@JoinColumn(name = "idrole") })

	private List<Role> roles;

	// bi-directional many-to-one association to Centre
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcentre")
	private Centre centre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idsession")
	private Session session;

	public Utilisateur() {
	}

	public Integer getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepersonnelcentre() {
		return codepersonnelcentre;
	}

	public void setCodepersonnelcentre(String codepersonnelcentre) {
		this.codepersonnelcentre = codepersonnelcentre;
	}

	public LocalDate getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(LocalDate datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		result = prime * result + ((codepersonnelcentre == null) ? 0 : codepersonnelcentre.hashCode());
		result = prime * result + ((datenaissance == null) ? 0 : datenaissance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((idutilisateur == null) ? 0 : idutilisateur.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		if (codepersonnelcentre == null) {
			if (other.codepersonnelcentre != null)
				return false;
		} else if (!codepersonnelcentre.equals(other.codepersonnelcentre))
			return false;
		if (datenaissance == null) {
			if (other.datenaissance != null)
				return false;
		} else if (!datenaissance.equals(other.datenaissance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (idutilisateur == null) {
			if (other.idutilisateur != null)
				return false;
		} else if (!idutilisateur.equals(other.idutilisateur))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Utilisateur [idutilisateur=" + idutilisateur + ", adresse=" + adresse + ", codepersonnelcentre="
				+ codepersonnelcentre + ", datenaissance=" + datenaissance + ", email=" + email + ", etat=" + etat
				+ ", nom=" + nom + ", password=" + password + ", prenom=" + prenom + ", tel=" + tel + ", roles=" + roles
				+ ", centre=" + centre + "]";
	}

}