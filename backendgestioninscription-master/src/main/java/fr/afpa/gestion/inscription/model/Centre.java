package fr.afpa.gestion.inscription.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the centre database table.
 * 
 */
@Entity
@NamedQuery(name = "Centre.findAll", query = "SELECT c FROM Centre c")
public class Centre implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The idcentre. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcentre")
	private Integer idcentre;

	/** The adresse. */
	@Column(length = 300, nullable = true)
	private String adresse;

	/** The nom. */
	@Column(length = 50, unique = true, nullable = false)
	private String nom;

	/** The telephone. */
	@Column(length = 10, nullable = true)
	private Integer telephone;

	/**
	 * Instantiates a new centre.
	 */
	public Centre() {
	}

	/**
	 * Instantiates a new centre.
	 *
	 * @param idcentre the idcentre
	 * @param adresse the adresse
	 * @param nom the nom
	 * @param telephone the telephone
	 */
	public Centre(Integer idcentre,String adresse, String nom, Integer telephone
			) {
		super();
		this.idcentre=idcentre;
		this.adresse = adresse;
		this.nom = nom;
		this.telephone = telephone;
		this.idcentre=idcentre;
		//this.utilisateurs = utilisateurs;
		//this.sessions = sessions;
	}

	/**
	 * Gets the idcentre.
	 *
	 * @return the idcentre
	 */
	public Integer getIdcentre() {
		return idcentre;
	}

	/**
	 * Sets the idcentre.
	 *
	 * @param idcentre the new idcentre
	 */
	public void setIdcentre(Integer idcentre) {
		this.idcentre = idcentre;
	}

	/**
	 * Gets the adresse.
	 *
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Sets the adresse.
	 *
	 * @param adresse the new adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the telephone.
	 *
	 * @return the telephone
	 */
	public Integer getTelephone() {
		return telephone;
	}

	/**
	 * Sets the telephone.
	 *
	 * @param telephone the new telephone
	 */
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((idcentre == null) ? 0 : idcentre.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centre other = (Centre) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (idcentre == null) {
			if (other.idcentre != null)
				return false;
		} else if (!idcentre.equals(other.idcentre))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
	
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Centre [idcentre=" + idcentre + ", adresse=" + adresse + ", nom=" + nom + ", telephone=" + telephone
				+ "]";
	}

}